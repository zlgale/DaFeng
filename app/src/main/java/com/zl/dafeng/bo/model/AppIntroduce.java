package com.zl.dafeng.bo.model;

import java.util.List;

/**
 */
public class AppIntroduce {


    /**
     * code : 200
     * msg : 操作成功
     * info : [{"id":"1","type":"1","title":"精选包介绍","jump_url":"http://www.miaodj.cn/h5/introduce/1.html","createtime":"2016-12-16 16:53:04","updatetime":"2016-12-16 16:53:06"},{"id":"2","type":"2","title":"注册协议","jump_url":"","createtime":"2016-12-16 16:53:04","updatetime":"2016-12-16 16:53:04"},{"id":"3","type":"3","title":"自助选品介绍","jump_url":"","createtime":"2016-12-16 16:53:04","updatetime":"2016-12-16 16:53:04"},{"id":"4","type":"4","title":"快速报价介绍","jump_url":"","createtime":"2016-12-16 16:53:04","updatetime":"2016-12-16 16:53:04"},{"id":"5","type":"5","title":"喵币介绍","jump_url":"","createtime":"2016-12-16 16:53:04","updatetime":"2016-12-16 16:53:04"},{"id":"6","type":"6","title":"账户余额介绍","jump_url":"","createtime":"2016-12-16 16:53:04","updatetime":"2016-12-16 16:53:04"},{"id":"7","type":"7","title":"客户推荐介绍","jump_url":"","createtime":"2016-12-16 16:53:04","updatetime":"2016-12-16 16:53:04"},{"id":"8","type":"8","title":"施工节点介绍","jump_url":"","createtime":"2016-12-16 16:53:04","updatetime":"2016-12-16 16:53:04"},{"id":"9","type":"9","title":"节点确认介绍","jump_url":"","createtime":"2016-12-16 16:53:04","updatetime":"2016-12-16 16:53:04"},{"id":"10","type":"10","title":"在线支付介绍","jump_url":"","createtime":"2016-12-16 16:53:04","updatetime":"2016-12-16 16:53:04"},{"id":"11","type":"11","title":"节点详情介绍","jump_url":"","createtime":"2016-12-16 16:53:04","updatetime":"2016-12-16 16:53:04"}]
     */

    private int code;
    private String msg;
    private List<InfoBean> info;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<InfoBean> getInfo() {
        return info;
    }

    public void setInfo(List<InfoBean> info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         * id : 1
         * type : 1
         * title : 精选包介绍
         * jump_url : http://www.miaodj.cn/h5/introduce/1.html
         * createtime : 2016-12-16 16:53:04
         * updatetime : 2016-12-16 16:53:06
         */

        private String id;
        private String type;
        private String title;
        private String jump_url;
        private String createtime;
        private String updatetime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getJump_url() {
            return jump_url;
        }

        public void setJump_url(String jump_url) {
            this.jump_url = jump_url;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(String updatetime) {
            this.updatetime = updatetime;
        }
    }
}
