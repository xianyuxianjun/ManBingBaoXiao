package com.chenxianyu.controller;

import com.chenxianyu.entity.Reslut;
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

    @PostMapping("/list")
    public Reslut list(){
        return Reslut.Success(userService.list());
    }

    @PostMapping("/getUser")
    public Reslut getUser(@RequestParam Integer id) {
        System.out.println(id);
        return Reslut.Success();
    }

}
