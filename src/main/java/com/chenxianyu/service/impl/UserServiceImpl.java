package com.chenxianyu.service.impl;

import com.chenxianyu.entity.User;
import com.chenxianyu.mapper.UserMapper;
import com.chenxianyu.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenxianyu
 * @since 2025-05-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
