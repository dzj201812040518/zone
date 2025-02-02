package com.cjl.basic.zone.project.layim.service.impl;

import com.cjl.basic.zone.project.layim.entity.Friend;
import com.cjl.basic.zone.project.layim.entity.Friends;
import com.cjl.basic.zone.project.layim.entity.Mine;
import com.cjl.basic.zone.project.layim.entity.SysMsg;
import com.cjl.basic.zone.project.layim.mapper.FriendsMapper;
import com.cjl.basic.zone.project.layim.mapper.SysMsgMapper;
import com.cjl.basic.zone.project.layim.service.FriendsService;
import com.cjl.basic.zone.project.user.mapper.UserMapper;
import com.cjl.basic.zone.utils.IdGenerat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author chen
 * @Date 2021/4/8 9:41
 * @Version 1.0
 */
@Service
public class FriendsServiceImpl implements FriendsService {

    @Resource
    private FriendsMapper friendsMapper;
    @Resource
    private SysMsgMapper sysMsgMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addFriend(Friend friend) {
        friend.setId(IdGenerat.getGeneratID());
        friend.setCreateTime(new Date());
        String uid = friend.getUid();
        //查询第一个分组列表
        friend.setGId(friendsMapper.getFriendGroupList(Integer.parseInt(uid)).get(0).getId());
        String fid = friend.getFid();
        boolean addFriend = friendsMapper.addFriend(friend);
        if (addFriend) {
            //添加两天好友关系
            boolean addFriend1 = friendsMapper.addFriend(new Friend().setId(IdGenerat.getGeneratID()).setUid(fid).setFid(uid).setCreateTime(friend.getCreateTime()).setGId(friendsMapper.getFriendGroupList(Integer.parseInt(fid)).get(0).getId()));
            if (addFriend1) {
                //添加系统消息
                String content = userMapper.selectUserById(Integer.valueOf(uid)).getUserName();
                SysMsg sysMsg = new SysMsg().setId(IdGenerat.getGeneratID()).setContent(content + "  已经同意你的好友申请")
                        .setUid(fid).setCreateTime(new Date()).setStatus("0");
                sysMsgMapper.addSysMsg(sysMsg);
                String userName = userMapper.selectUserById(Integer.valueOf(fid)).getUserName();
                sysMsg.setId(IdGenerat.getGeneratID()).setContent("你同意了" + userName + "的好友申请").setUid(uid);
                sysMsgMapper.addSysMsg(sysMsg);
                return true;
            }


        }
        return false;
    }

    @Override
    public List<Mine> getUserFriend(String userId) {
        return friendsMapper.getUserFriend(userId);
    }

    @Override
    public List<Friends> getFriendGroupList(Integer accountId) {
        return friendsMapper.getFriendGroupList(accountId);
    }

    @Override
    public int createGroup(Friends friends) {
        return friendsMapper.createGroup(friends);
    }
}
