package com.comagic.tabler.qutu.model;

import java.util.List;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/8 14:45
 * 邮箱: leiyuanxin@outlook.com
 * 描述：
 */

public class QtListBean {

        /**
         * allPages : 77
         * ret_code : 0
         * contentlist : [{"title":"水下一幕把我激动坏了","img":"http://sc3.hao123img.com/data/14fd96359d8a8f26f18f621ef22a21d5_0","type":2,"ct":"2017-09-08 19:30:04.852"},{"title":"现在的老师都爱开玩笑吗","img":"http://sc4.hao123img.com/data/4a77a34472538b2df4fe4a16b5bb76a9_0","type":2,"ct":"2017-09-08 19:30:04.852"},{"title":"收到荣誉证书好像哪里不太对","img":"http://sc1.hao123img.com/data/6e39727290bb3b4077f1ac37007e7547_0","type":2,"ct":"2017-09-08 18:30:02.593"},{"title":"这腿也是没谁了","img":"http://sc1.hao123img.com/data/1bcfc7d281e5e180b937b6ace5b99cdf_430","type":2,"ct":"2017-09-08 18:30:02.576"},{"title":"这主人一定经历了什么！","img":"http://sc3.hao123img.com/data/6b92e194505bfb1ae751a64699093eb5_0","type":2,"ct":"2017-09-08 18:00:11.194"},{"title":"这个证真让我长见识了","img":"http://sc0.hao123img.com/data/11e8c11400cc8ab8dc0a550155548e96_0","type":2,"ct":"2017-09-08 18:00:11.193"},{"title":"也是为有钱人操碎了心","img":"http://sc4.hao123img.com/data/b71aaf681d71db5c9251fb2704c4b805_0","type":2,"ct":"2017-09-08 17:30:11.715"},{"title":"取到钱，感觉被施舍了","img":"http://sc2.hao123img.com/data/f9a1247010010e7809dc00592329adea_0","type":2,"ct":"2017-09-08 17:30:11.715"},{"title":"不敢惹的人，霸气啊","img":"http://sc3.hao123img.com/data/27ee7afd15b991633d963e8e61db0613_0","type":2,"ct":"2017-09-08 17:30:11.714"},{"title":"对比一下，妹子还是最迷人的~","img":"http://sc4.hao123img.com/data/93e18f7e0e1336871e5ae17a6d7182e0_0","type":2,"ct":"2017-09-08 17:30:11.714"}]
         * currentPage : 1
         * allNum : 769
         * maxResult : 10
         */

        private int allPages;
        private int ret_code;
        private int currentPage;
        private int allNum;
        private int maxResult;
        private List<ContentlistBean> contentlist;

        public int getAllPages() {
            return allPages;
        }

        public void setAllPages(int allPages) {
            this.allPages = allPages;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getAllNum() {
            return allNum;
        }

        public void setAllNum(int allNum) {
            this.allNum = allNum;
        }

        public int getMaxResult() {
            return maxResult;
        }

        public void setMaxResult(int maxResult) {
            this.maxResult = maxResult;
        }

        public List<ContentlistBean> getContentlist() {
            return contentlist;
        }

        public void setContentlist(List<ContentlistBean> contentlist) {
            this.contentlist = contentlist;
        }

        public static class ContentlistBean {
            /**
             * title : 水下一幕把我激动坏了
             * img : http://sc3.hao123img.com/data/14fd96359d8a8f26f18f621ef22a21d5_0
             * type : 2
             * ct : 2017-09-08 19:30:04.852
             */

            private String title;
            private String img;
            private int type;
            private String ct;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }
        }
}
