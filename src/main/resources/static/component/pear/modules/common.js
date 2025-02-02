layui.define(['jquery', 'element', 'table'], function (exports) {
    "use strict";

    /**
     * 常用封装类
     * */
    var MOD_NAME = 'common',
        $ = layui.jquery,
        table = layui.table,
        element = layui.element;

    var common = new function () {

        /**
         * 获取当前表格选中字段
         * @param obj 表格回调参数
         * @param field 要获取的字段
         * */
        this.checkField = function (obj, field) {
            let data = table.checkStatus(obj.config.id).data;
            if (data.length === 0) {
                return "";
            }
            let ids = "";
            for (let i = 0; i < data.length; i++) {
                ids += data[i][field] + ",";
            }
            ids = ids.substr(0, ids.length - 1);
            return ids;
        }

        /**
         * 提交 json 数据
         * @param data 提交数据
         * @param href 提交接口
         * @param table 刷新父级表
         *
         * */
        this.submit = function (data, href, table, callback) {
            $.ajax({
                url: href,
                data: JSON.stringify(data),
                dataType: 'json',
                contentType: 'application/json',
                type: 'post',
                success: callback != null ? callback(result) : function (result) {
                    if (result.code == 0) {
                        layer.msg(result.msg, {icon: 1, time: 1000}, function () {
                            parent.layer.close(parent.layer.getFrameIndex(window.name));//关闭当前页
                            parent.layui.table.reload(table);
                        });
                    } else {
                        layer.msg(result.msg, {icon: 2, time: 1000});
                    }
                }
            })
        }
        this.enableMsg = function (index, data, msg) {
            setTimeout(function () {
                top.layer.close(index);
                if (data.code == 0) {
                    layer.msg(msg + "成功");
                } else {
                    layer.msg(msg + "失败");
                }
            }, 500);
        }
        this.ajaxMsg = function (res, index) {
            top.layer.close(index);
            if (res.code === 0) {
                layer.msg(res.msg, {icon: 1, time: 1000}, function () {
                    parent.layer.close(parent.layer.getFrameIndex(window.name));//关闭当前页
                });
            } else {
                layer.msg(res.msg, {icon: 2, time: 1000});
            }
        }
        this.initLayIm = function () {
            var config = {
                url: 'layim/login',
                dataType: 'json',
                type: 'GET',
                success: function (result) {
                    debugger
                    if (result.code == 0) {
                        console.log('layIm初始化成功')
                    } else {
                        layer.msg(result.msg, {icon: 2, time: 1000});
                    }
                }
            }
            $.ajax(config)
        }
    }
    exports(MOD_NAME, common);
});
