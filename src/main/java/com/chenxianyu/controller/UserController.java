package com.chenxianyu.controller;

import ch.qos.logback.core.util.StringUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenxianyu.entity.Reslut;
import com.chenxianyu.entity.User;
import com.chenxianyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenxianyu
 * @since 2025-05-25
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 查询用户列表
     * @param current 当前页
     * @param size 大小
     * @param username 用户名 可选
     * @param role 角色 可选
     * @param phone 手机号 可选
     * @param fullName 姓名 可选
     * @return 用户列表
     */
    @GetMapping("/list")
    public Reslut list(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String role,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String fullName

    ){
        Page<User> page = new Page<>(current,size);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtil.notNullNorEmpty(username),User::getUsername,username);
        queryWrapper.eq(StringUtil.notNullNorEmpty(role),User::getRole,role);
        queryWrapper.eq(StringUtil.notNullNorEmpty(phone),User::getUsername,username);
        queryWrapper.like(StringUtil.notNullNorEmpty(fullName),User::getFullName,fullName);
        Page<User> userPage = userService.page(page, queryWrapper);
        return Reslut.Success(userPage);
    }

    /**
     * 查询用户信息
     * @param id 用户id
     * @return 用户信息
     */
    @GetMapping("/get/{id}")
    public Reslut getUser(@PathVariable Integer id) {
        User user = userService.getById(id);
        if (user == null) {
            return Reslut.Fail("用户不存在");
        }
        return Reslut.Success(user);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Reslut deleteUser(@PathVariable Integer id) {
        boolean delete = userService.removeById(id);
        if (!delete){
            return Reslut.Fail("删除失败");
        }
        return Reslut.Success();
    }

    /**
     * 新增用户
     * @param user 用户信息
     * @return
     */
    @PostMapping("/saveUser")
    public Reslut saveUser(@RequestBody User user) {
        boolean save = userService.save(user);
        if (!save) {
            return Reslut.Fail("保存失败");
        }
        return Reslut.Success();
    }

    /**
     * 修改用户
     * @param user 用户信息
     * @return
     */
    @PostMapping("/update")
    public Reslut updateUser(@RequestBody User user) {
        boolean update = userService.updateById(user);
        if (!update) {
            return Reslut.Fail("修改失败");
        }
        return Reslut.Success();
    }

}
