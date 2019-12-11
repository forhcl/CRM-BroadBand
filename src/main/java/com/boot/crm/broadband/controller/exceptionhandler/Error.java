package com.boot.crm.broadband.controller.exceptionhandler;

/**
 * @author Hogan_Lee
 * @create 2019-11-04 21:15
 * 统一异常返回对象
 */
public class Error {
    //错误信息
    private String message;

    public Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
