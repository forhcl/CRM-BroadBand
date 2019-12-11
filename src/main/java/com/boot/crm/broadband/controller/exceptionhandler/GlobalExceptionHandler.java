package com.boot.crm.broadband.controller.exceptionhandler;

import com.boot.crm.broadband.exception.CustomerNotFoundException;
import com.boot.crm.broadband.exception.UserNotFoundException;
import org.apache.ibatis.binding.BindingException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 控制器通知：将所有的@ExceptionHandler方法收集到一个类中，
 * 对所有的控制器的异常在同一个地方进行一致的处理
 *
 * @author Hogan_Lee
 * @create 2019-09-28 12:52
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomerNotFoundException.class)
    public Error customerNotFound(CustomerNotFoundException e) {
        long userId = e.getCust_id();
        return new Error("Customer [" + userId + "] not found");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public Error userNotFound(UserNotFoundException e) {
        long userId = e.getUserId();
        return new Error("User [" + userId + "] not found");
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Error errorHandler(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        StringBuilder errorMsg = new StringBuilder();
        for (ObjectError error : result.getAllErrors()) {
            errorMsg.append(error.getDefaultMessage()).append(",");
        }
        errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
        return new Error(errorMsg.toString());
    }

}
