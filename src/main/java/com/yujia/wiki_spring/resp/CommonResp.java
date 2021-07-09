package com.yujia.wiki_spring.resp;

public class CommonResp<T> {
        /*return true when connect successfully*/
        private boolean success = true;

        private String message;

        private T content;

        public boolean getSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public T getContent() {
            return content;
        }

        public void setContent(T content) {
            this.content = content;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("ResponseDto{");
            sb.append("success=").append(success);
            sb.append(", message='").append(message).append('\'');
            sb.append(", content=").append(content);
            sb.append('}');
            return sb.toString();
        }
}
