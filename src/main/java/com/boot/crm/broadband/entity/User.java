package com.boot.crm.broadband.entity;

import com.boot.crm.broadband.vaildator.UsernameConstraint;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.List;

/**
 * 登录用户，包含管理员和普通用户（工作人员）两种角色的用户
 * @author Hogan_Lee
 * @create 2019-12-03 16:51
 */
public class User implements UserDetails {
    private Integer id; //用户Id
    @UsernameConstraint(message = "用户名已存在")
    @NotBlank(message = "用户名不能为空~",groups = {GroupVaild.class})
    private String username; //用户名字
    @NotBlank(message = "密码不能为空~",groups = {GroupVaild.class})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password; //用户密码
    private boolean state;//用户状态：是否可用
    private String roles; //角色，管理员和普通用户（工作人员）两种角色
    private String phone;
    private String address;
    private String email;


    @JsonView(UserSimpleView.class)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonView(UserSimpleView.class)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @JsonView(UserSimpleView.class)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(UserDetailView.class)
    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    private List<GrantedAuthority> authorities;

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return state;
    }

    public interface UserSimpleView{}

    public interface UserDetailView extends UserSimpleView{}

    //用来校验注解分类
    public interface GroupVaild{}
}
