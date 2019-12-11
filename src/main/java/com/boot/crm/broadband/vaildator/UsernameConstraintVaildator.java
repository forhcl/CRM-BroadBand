package com.boot.crm.broadband.vaildator;

import com.boot.crm.broadband.dao.UserMapper;
import com.boot.crm.broadband.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Hogan_Lee
 * @create 2019-12-04 18:53
 */
//Spring容器能够自动找到这个类，因为实现了~  所以不用我们写@component
//两个泛型，其中String说明注解只能放在String类型的域上面
public class UsernameConstraintVaildator implements ConstraintValidator<UsernameConstraint, String> {
    @Autowired
    private UserMapper userMapper;

    //返回值代表检验的结果
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        User user = userMapper.findByUserName(s);
        //当数据库中没有相同名字的用户时，返回true
        if (user == null)
            return true;
        return false;
    }
}
