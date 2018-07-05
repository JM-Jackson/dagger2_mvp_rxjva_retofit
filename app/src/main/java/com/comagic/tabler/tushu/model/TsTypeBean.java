package com.comagic.tabler.tushu.model;

import java.util.List;

/**
 * 作者: leiyuanxin
 * 时间: 2017/9/11 11:40
 * 邮箱: leiyuanxin@outlook.com
 * 描述：
 */

public class TsTypeBean {


        /**
         * ret_code : 0
         * flag : true
         * success : true
         * bookClass : [{"id":"1","name":"孕妇育儿图书"},{"id":"2","name":"美容时尚图书"},{"id":"3","name":"健康养生图书"},{"id":"4","name":"两性生活图书"},{"id":"5","name":"美食烹饪图书"},{"id":"6","name":"修养心里图书"},{"id":"7","name":"家庭教育图书"},{"id":"8","name":"幽默笑话图书"},{"id":"9","name":"生活杂谈图书"},{"id":"10","name":"其它图书"}]
         */

        private int ret_code;
        private boolean flag;
        private boolean success;
        private List<BookClassBean> bookClass;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public List<BookClassBean> getBookClass() {
            return bookClass;
        }

        public void setBookClass(List<BookClassBean> bookClass) {
            this.bookClass = bookClass;
        }

        public static class BookClassBean {
            /**
             * id : 1
             * name : 孕妇育儿图书
             */

            private String id;
            private String name;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
}
