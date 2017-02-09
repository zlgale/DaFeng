package com.zl.dafeng.bo.model;

import java.util.List;

/**
 * <一句话功能简述>
 *
 * @author DaFeng 2017-02-05 16:13
 * @email 598787663@qq.com
 */

public class BelleModel {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"newslist":[{"title":"[贴图]天使面孔魔鬼身材","picUrl":"http://image.hnol.net/c/2017-02/03/17/201702031714433641-4659347.jpg","description":"华声美女","ctime":"2017-02-09 11:00","url":"http://bbs.voc.com.cn/mm/meinv-7644102-0-1.html"},{"title":"李李七七喜喜 [IMISS爱蜜社] 20170110 VOL146 雅致清丽柔情似水圣诞小鹿 酥胸玉兔滑腻美臀性感内衣诱惑","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_213a6f6e1a11a19f897bb4de7d320a60-683x1024.jpg","description":"美女写真","ctime":"2017-02-09 10:00","url":"http://m.xxxiao.com/118084"},{"title":"静心若尘","picUrl":"http://image.hnol.net/c/2017-02/09/08/201702090834032171-239867.jpg","description":"华声美女","ctime":"2017-02-09 09:00","url":"http://bbs.voc.com.cn/mm/meinv-7649441-0-1.html"},{"title":"涟漪sara漪娜 [TouTiao头条女神] 20170206 女下属的诱惑 雪肌玉肤肉感美腿翘臀凹凸性感私房照","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_67bfee872ddb0ebb32a8118e5b4598ba-683x1024.jpg","description":"美女写真","ctime":"2017-02-09 09:00","url":"http://m.xxxiao.com/118082"},{"title":"唐琪儿Beauty [MyGirl美媛馆] 20170109 VOL237 王艳卓粉肌脂腻杨柳细腰妩媚动人大尺度内衣写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_55ee5567a70cd42570324b5370991266-683x1024.jpg","description":"美女写真","ctime":"2017-02-09 09:00","url":"http://m.xxxiao.com/118083"},{"title":"[贴图]内心深处的孤独","picUrl":"http://image.hnol.net/c/2017-02/08/18/201702081849064341-4659347.jpg","description":"华声美女","ctime":"2017-02-08 19:00","url":"http://bbs.voc.com.cn/mm/meinv-7649144-0-1.html"},{"title":"长发美女 陈丹萌 定制私房写真靓照","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_7b5b4981033209a45e85a7bab49b8a93-768x1024.jpg","description":"美女写真","ctime":"2017-02-08 19:00","url":"http://m.xxxiao.com/117994"},{"title":"台妹嫩模女郎 Irene小头(余晨瑀) 甜美少女比基尼靓丽美拍","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_452936a257ac62e54635271242c4606d.jpg","description":"美女写真","ctime":"2017-02-08 19:00","url":"http://m.xxxiao.com/117995"},{"title":"巨乳女神 刘娅希 [BoLoli波萝社新刊] 2017120 BOL019 泰国泳池嬉戏波涛胸涌比基尼清凉一夏","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_89c231f55669805191aae5fa50d2480d.jpg","description":"美女写真","ctime":"2017-02-08 19:00","url":"http://m.xxxiao.com/117996"},{"title":"[贴图]沉思","picUrl":"http://image.hnol.net/c/2017-02/08/17/201702081751012261-4659347.jpg","description":"华声美女","ctime":"2017-02-08 18:00","url":"http://bbs.voc.com.cn/mm/meinv-7649101-0-1.html"}],"code":200,"msg":"success"}
     */

    private String showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBodyBean showapi_res_body;

    public String getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(String showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * newslist : [{"title":"[贴图]天使面孔魔鬼身材","picUrl":"http://image.hnol.net/c/2017-02/03/17/201702031714433641-4659347.jpg","description":"华声美女","ctime":"2017-02-09 11:00","url":"http://bbs.voc.com.cn/mm/meinv-7644102-0-1.html"},{"title":"李李七七喜喜 [IMISS爱蜜社] 20170110 VOL146 雅致清丽柔情似水圣诞小鹿 酥胸玉兔滑腻美臀性感内衣诱惑","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_213a6f6e1a11a19f897bb4de7d320a60-683x1024.jpg","description":"美女写真","ctime":"2017-02-09 10:00","url":"http://m.xxxiao.com/118084"},{"title":"静心若尘","picUrl":"http://image.hnol.net/c/2017-02/09/08/201702090834032171-239867.jpg","description":"华声美女","ctime":"2017-02-09 09:00","url":"http://bbs.voc.com.cn/mm/meinv-7649441-0-1.html"},{"title":"涟漪sara漪娜 [TouTiao头条女神] 20170206 女下属的诱惑 雪肌玉肤肉感美腿翘臀凹凸性感私房照","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_67bfee872ddb0ebb32a8118e5b4598ba-683x1024.jpg","description":"美女写真","ctime":"2017-02-09 09:00","url":"http://m.xxxiao.com/118082"},{"title":"唐琪儿Beauty [MyGirl美媛馆] 20170109 VOL237 王艳卓粉肌脂腻杨柳细腰妩媚动人大尺度内衣写真","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_55ee5567a70cd42570324b5370991266-683x1024.jpg","description":"美女写真","ctime":"2017-02-09 09:00","url":"http://m.xxxiao.com/118083"},{"title":"[贴图]内心深处的孤独","picUrl":"http://image.hnol.net/c/2017-02/08/18/201702081849064341-4659347.jpg","description":"华声美女","ctime":"2017-02-08 19:00","url":"http://bbs.voc.com.cn/mm/meinv-7649144-0-1.html"},{"title":"长发美女 陈丹萌 定制私房写真靓照","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_7b5b4981033209a45e85a7bab49b8a93-768x1024.jpg","description":"美女写真","ctime":"2017-02-08 19:00","url":"http://m.xxxiao.com/117994"},{"title":"台妹嫩模女郎 Irene小头(余晨瑀) 甜美少女比基尼靓丽美拍","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_452936a257ac62e54635271242c4606d.jpg","description":"美女写真","ctime":"2017-02-08 19:00","url":"http://m.xxxiao.com/117995"},{"title":"巨乳女神 刘娅希 [BoLoli波萝社新刊] 2017120 BOL019 泰国泳池嬉戏波涛胸涌比基尼清凉一夏","picUrl":"http://m.xxxiao.com/wp-content/uploads/sites/3/2017/02/m.xxxiao.com_89c231f55669805191aae5fa50d2480d.jpg","description":"美女写真","ctime":"2017-02-08 19:00","url":"http://m.xxxiao.com/117996"},{"title":"[贴图]沉思","picUrl":"http://image.hnol.net/c/2017-02/08/17/201702081751012261-4659347.jpg","description":"华声美女","ctime":"2017-02-08 18:00","url":"http://bbs.voc.com.cn/mm/meinv-7649101-0-1.html"}]
         * code : 200
         * msg : success
         */

        private String code;
        private String msg;
        private List<NewslistBean> newslist;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List<NewslistBean> getNewslist() {
            return newslist;
        }

        public void setNewslist(List<NewslistBean> newslist) {
            this.newslist = newslist;
        }

        public static class NewslistBean {
            /**
             * title : [贴图]天使面孔魔鬼身材
             * picUrl : http://image.hnol.net/c/2017-02/03/17/201702031714433641-4659347.jpg
             * description : 华声美女
             * ctime : 2017-02-09 11:00
             * url : http://bbs.voc.com.cn/mm/meinv-7644102-0-1.html
             */

            private String title;
            private String picUrl;
            private String description;
            private String ctime;
            private String url;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCtime() {
                return ctime;
            }

            public void setCtime(String ctime) {
                this.ctime = ctime;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
