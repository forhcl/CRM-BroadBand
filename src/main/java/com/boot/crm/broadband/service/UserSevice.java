package com.boot.crm.broadband.service;

import com.boot.crm.broadband.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 处理用户操作的一些逻辑
 * @author Hogan_Lee
 * @create 2019-12-04 10:52
 */
public interface UserSevice {
    /**
     * 查询所有的用户
     * @param pageNum 第几页
     * @param pageSize 每一页的记录数量
     * @return
     */
    List<User> userList(int pageNum, int pageSize);

    /**
     * 查询指定id的用户
     * @param id
     * @return
     */
    User findUser(Integer id);

    /**
     * 添加用户并返回回填了id的用户
     * @param user
     * @return
     */
    @Transactional
    int addUser(User user);

    /**
     * 删除指定Id的用户
     * @param id
     */
    @Transactional
    int deleteUser(Integer id);

    /**
     * 修改用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 启用或者禁用某个用户。
     * 当用户当前的启用的，也就是state=1，调用之后就变成0
     * 当用户当前是禁用的，就是是state=0，调用之后就变成1.
     * @param id
     */
    int negationEnableState(Integer id);
}
