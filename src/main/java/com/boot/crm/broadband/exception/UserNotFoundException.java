package com.boot.crm.broadband.exception;

/**
 * @author Hogan_Lee
 * @create 2019-12-03 17:09
 */
public class UserNotFoundException extends RuntimeException {
    private Integer userId;

    public UserNotFoundException(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
