package com.boot.crm.broadband.vaildator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义校验注解
 * 用于插入和修改的时候判断数据库加了唯一约束的username是不是已经存在
 * @author Hogan_Lee
 * @create 2019-12-04 18:50
 */
//这个注解可以被用在什么地方
@Target({ElementType.FIELD,ElementType.METHOD})
//运行时注解
@Retention(RetentionPolicy.RUNTIME)
//指定校验逻辑所在的类
@Constraint(validatedBy = UsernameConstraintVaildator.class)
public @interface UsernameConstraint {
    String message() default "{javax.validation.constraints.NotBlank.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
