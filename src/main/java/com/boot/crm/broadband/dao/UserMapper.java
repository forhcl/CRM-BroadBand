package com.boot.crm.broadband.dao;

import com.boot.crm.broadband.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Hogan_Lee
 * @create 2019-12-03 17:02
 */
@Mapper
@Repository
public interface UserMapper {

    /**
     * 通过用户名查找对应的用户
     *
     * @param username
     * @return
     */
    User findByUserName(String username);

    /**
     * 查询所有的用户
     *
     * @return
     */
    List<User> userList();

    /**
     * 查询指定id的用户
     *
     * @param id
     * @return
     */
    User findUser(Integer id);

    /**
     * 添加用户并返回回填了id的用户
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除指定Id的用户
     *
     * @param id
     */
    int deleteUser(Integer id);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 启用或者禁用某个用户。
     * 当用户当前的启用的，也就是state=1，调用之后就变成0
     * 当用户当前是禁用的，就是是state=0，调用之后就变成1.
     *
     * @param id
     */
    int negationEnableState(Integer id);
}
