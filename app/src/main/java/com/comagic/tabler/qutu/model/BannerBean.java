package com.comagic.tabler.qutu.model;

import java.util.List;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/11 09:02
 * 邮箱: leiyuanxin@outlook.com
 * 描述：
 */

public class BannerBean {

    /**
     * returnMap : [{"id":23,"sort":3,"question_type":"","img":"http://file.cctax.com.cn//file_upload/image/20170812/20170812193822_23_small.png","link_id":273,"link_type":3},{"id":36,"sort":3,"question_type":"","img":"http://file.cctax.com.cn//file_upload/image/20170812/20170812194121_937_small.png","link_id":796,"link_type":3},{"id":33,"sort":3,"question_type":"","img":"http://file.cctax.com.cn//file_upload/image/20170812/20170812194004_349_small.png","link_id":797,"link_type":3},{"id":34,"sort":3,"question_type":"","img":"http://file.cctax.com.cn//file_upload/image/20170812/20170812194044_100_small.png","link_id":770,"link_type":3}]
     * type : 1
     * msg : 成功
     */

    private int type;
    private String msg;
    private List<ReturnMapBean> returnMap;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ReturnMapBean> getReturnMap() {
        return returnMap;
    }

    public void setReturnMap(List<ReturnMapBean> returnMap) {
        this.returnMap = returnMap;
    }

    public static class ReturnMapBean {
        /**
         * id : 23
         * sort : 3
         * question_type :
         * img : http://file.cctax.com.cn//file_upload/image/20170812/20170812193822_23_small.png
         * link_id : 273
         * link_type : 3
         */

        private int id;
        private int sort;
        private String question_type;
        private String img;
        private int link_id;
        private int link_type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getQuestion_type() {
            return question_type;
        }

        public void setQuestion_type(String question_type) {
            this.question_type = question_type;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getLink_id() {
            return link_id;
        }

        public void setLink_id(int link_id) {
            this.link_id = link_id;
        }

        public int getLink_type() {
            return link_type;
        }

        public void setLink_type(int link_type) {
            this.link_type = link_type;
        }
    }
}
