package com.boot.crm.broadband.controller;

import com.boot.crm.broadband.entity.User;
import com.boot.crm.broadband.exception.UserNotFoundException;
import com.boot.crm.broadband.service.UserSevice;
import com.boot.crm.broadband.service.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

/**
 * 对当前登录用户的处理
 *
 * @author Hogan_Lee
 * @create 2019-12-04 16:21
 */
@RestController
public class ActiveUserController {
    @Autowired
    private UserSevice userSevice;

    @Autowired
    private UserDetailServiceImpl userDetailService;

    //获取当前用户的登录信息
    @GetMapping("/login.message")
    public UserDetails getUserDetial(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        UserDetails user = userDetailService.loadUserByUsername(principal.getName());
        return user;
    }

    //修改当前登录用户的个人信息
    @PutMapping("/active_user.message")
    public User updateActiveUser(@RequestBody @Valid User user,HttpServletRequest request){
        //将当前登录用户的id取出来，并设置到对应字段中
        Principal principal = request.getUserPrincipal();
        User user1=(User)userDetailService.loadUserByUsername(principal.getName());
        Integer id=user1.getId();
        user.setId(id);
        int nums=userSevice.updateUser(user);
        if(nums==0){
            throw new UserNotFoundException(id);
        }
        return userSevice.findUser(id);
    }

}
