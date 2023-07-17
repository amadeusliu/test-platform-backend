package cn.edu.tju.domain;


import java.util.Date;

public class ResponseData {
    private String status;
    private int code;
    private String message;
    private Object data;
    private Date date;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ResponseBuilder newBuilder(){
        return new ResponseBuilder();
    }

    public static class ResponseBuilder{
        private ResponseData responseData = new ResponseData();
        public ResponseBuilder buildStatus(String status){
            responseData.setStatus(status);
            return this;
        }

        public ResponseBuilder buildCode(int code){
            responseData.setCode(code);
            return this;
        }

        public ResponseBuilder buildMessage(String message){
            responseData.setMessage(message);
            return this;
        }

        public ResponseBuilder buildData(Object data){
            responseData.setData(data);
            return this;
        }

        public ResponseBuilder buildDate(Date date){
            responseData.setDate(date);
            return this;
        }




        public ResponseData build(){
            return responseData;
        }

    }
}
