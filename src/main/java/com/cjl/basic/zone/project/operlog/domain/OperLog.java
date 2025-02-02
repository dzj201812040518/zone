package com.cjl.basic.zone.project.operlog.domain;

import com.cjl.basic.zone.framework.web.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 操作日志记录表 oper_log
 *
 * @author chen
 */
public class OperLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 日志主键
     */
//    @Excel(name = "操作序号")
    private Long operId;

    /**
     * 操作模块
     */
//    @Excel(name = "操作模块")
    private String title;

    /**
     * 操作业务类型
     */
//    @Excel(name = "业务类型", readConverterExp = "0=其它,1=新增,2=修改,3=删除,4=授权,5=导出,6=导入,7=强退,8=生成代码,9=清空数据")
    private Integer businessType;

    /**
     * 请求方法
     */
//    @Excel(name = "请求方法")
    private String method;

    /**
     * 公司ID
     */
    private Integer mfrsId;

    /**
     * 操作人类别
     */
//    @Excel(name = "操作类别", readConverterExp = "0=其它,1=后台用户,2=手机端用户")
    private Integer operatorType;

    /**
     * 操作人员
     */
//    @Excel(name = "操作人员")
    private String operName;

    /**
     * 组织机构
     */
//    @Excel(name = "组织机构")
    private String deptName;

    /**
     * 请求url
     */
//    @Excel(name = "请求地址")
    private String operUrl;

    /**
     * 操作地址
     */
//    @Excel(name = "操作地址")
    private String operIp;

    /**
     * 操作地点
     */
//    @Excel(name = "操作地点")
    private String operLocation;

    /**
     * 请求参数
     */
//    @Excel(name = "请求参数")
    private String operParam;

    /**
     * 状态0正常 1异常
     */
//    @Excel(name = "状态", readConverterExp = "0=正常,1=异常")
    private Integer status;

    /**
     * 错误消息
     */
//    @Excel(name = "错误消息")
    private String errorMsg;

    /**
     * 操作时间
     */
//    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date operTime;

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOperUrl() {
        return operUrl;
    }

    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl;
    }

    public String getOperIp() {
        return operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    public String getOperLocation() {
        return operLocation;
    }

    public void setOperLocation(String operLocation) {
        this.operLocation = operLocation;
    }

    public String getOperParam() {
        return operParam;
    }

    public void setOperParam(String operParam) {
        this.operParam = operParam;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }


    public Integer getMfrsId() {
        return mfrsId;
    }

    public void setMfrsId(Integer mfrsId) {
        this.mfrsId = mfrsId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("operId", getOperId())
                .append("title", getTitle())
                .append("businessType", getBusinessType())
                .append("method", getMethod())
                .append("operatorType", getOperatorType())
                .append("operName", getOperName())
                .append("deptName", getDeptName())
                .append("operUrl", getOperUrl())
                .append("operIp", getOperIp())
                .append("operLocation", getOperLocation())
                .append("operParam", getOperParam())
                .append("status", getStatus())
                .append("errorMsg", getErrorMsg())
                .append("operTime", getOperTime())
                .toString();
    }
}
