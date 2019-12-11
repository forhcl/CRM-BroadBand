package com.boot.crm.broadband.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.crm.broadband.dto.ArrayObject;
import com.boot.crm.broadband.entity.User;
import com.boot.crm.broadband.exception.UserNotFoundException;
import com.boot.crm.broadband.service.UserSevice;
import com.fasterxml.jackson.annotation.JsonView;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 对用户进行管理：超级管理员才有的权限
 *
 * @author Hogan_Lee
 * @create 2019-12-03 18:13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserSevice userSevice;

    /**
     * 查询所有用户（工作人员）
     *
     * @param pageNum  分页第几页
     * @param pageSize 每页多少记录
     * @return
     */
    //这里和pageHelper和jackson冲突，使用不了@JsonView
    @GetMapping
    public PageInfo<User> findAll(@RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "4") int pageSize) {
        List<User> users = userSevice.userList(pageNum, pageSize);
        PageInfo<User> userPageInfo = new PageInfo(users);
        return userPageInfo;
    }

    /**
     * 根据id查询对应的用户
     *
     * @param id
     * @return
     */
    @JsonView(User.UserDetailView.class)
    @GetMapping("/{id:\\d+}")
    public User findCustomer(@PathVariable Integer id) {
        User user = userSevice.findUser(id);
        if (user == null)
            throw new UserNotFoundException(id);
        return user;
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @PostMapping
    @Validated(User.GroupVaild.class)
    public User addOne(@RequestBody @Valid User user) {
        int nums = userSevice.addUser(user);
        return user;
    }

    /**
     * 删除指定id的用户
     *
     * @param id
     */
    @DeleteMapping("/{id:\\d+}")
    public void deleteOne(@PathVariable Integer id) {
        //删除操作影响的行数
        int nums = userSevice.deleteUser(id);
        if (nums == 0)
            throw new UserNotFoundException(id);
    }

    /**
     * 批量删除
     * 1.不能传数组，要封装成一个对象    单元测试通过，postman通过
     * 2.不能用method:DELETE,得method:POST   单元测试通过，postman通过
     * 3.对象里的数组必须用双引号包起来  单元测试通过，最后通过了
     *
     * @param arrayObject
     */
    @PostMapping("/batchdelete")
    public void deleteBatch(@RequestBody ArrayObject arrayObject) {
        List<Integer> ids = JSONObject.parseArray(arrayObject.getIds(), Integer.class);
        if (ids != null && ids.size() != 0) {
            for (int i = 0; i < ids.size() && ids.get(i) != null; i++) {
                userSevice.deleteUser(ids.get(i));
            }
        }
    }

    @PutMapping("/{id:\\d+}")
    public User updateUser(@PathVariable Integer id, @RequestBody @Valid User user) {
        user.setId(id);
        int nums = userSevice.updateUser(user);
        if (nums == 0) {
            throw new UserNotFoundException(id);
        }
        return userSevice.findUser(id);
    }

    @PatchMapping("/{id:\\d+}")
    public void enable(@PathVariable Integer id) {
        int nums = userSevice.negationEnableState(id);
        if (nums == 0) {
            throw new UserNotFoundException(id);
        }
    }
}
