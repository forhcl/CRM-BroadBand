package com.boot.crm.broadband.service.impl;

import com.boot.crm.broadband.dao.UserMapper;
import com.boot.crm.broadband.entity.Customer;
import com.boot.crm.broadband.entity.User;
import com.boot.crm.broadband.service.UserSevice;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Hogan_Lee
 * @create 2019-12-04 10:54
 */
@Service
public class UserServiceImpl implements UserSevice {
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> userList(int pageNum, int pageSize) {
        //调用pagehelper分页，采用startPage方式。注意：startPage应放在Mapper查询函数之前
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("id ASC");
        List<User> users=userMapper.userList();
        return users;
    }

    @Override
    public User findUser(Integer id) {
        return userMapper.findUser(id);
    }

    @Override
    public int addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        if(user.getPassword()!=null)
        user.setPassword(encoder.encode(user.getPassword()));
        return userMapper.updateUser(user);
    }

    @Override
    public int negationEnableState(Integer id) {
        return userMapper.negationEnableState(id);
    }
}
