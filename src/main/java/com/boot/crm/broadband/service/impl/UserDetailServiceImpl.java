package com.boot.crm.broadband.service.impl;

import com.boot.crm.broadband.dao.UserMapper;
import com.boot.crm.broadband.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 处理SpringSecurity的登录逻辑
 * @author Hogan_Lee
 * @create 2019-12-03 17:07
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //从数据库中尝试读取用户
        User user=userMapper.findByUserName(username);
        //用户不存在，抛出异常
        if(user==null){
            throw new UsernameNotFoundException("用户【"+username+"】不存在！");
        }
        //将数据库形式的roles解析为UserDetails的权限集
        //AuthorityUtils.commaSeparatedStringToAuthorityList是SpringSecurity
        //提供的，该方法用于将逗号隔开的权限集字符切割成可用的权限对象列表
        //当然也可以自己实现，如用分号来隔开等
        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));
        return user;
    }
}
