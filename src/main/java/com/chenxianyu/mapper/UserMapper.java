package com.chenxianyu.mapper;

import com.chenxianyu.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenxianyu
 * @since 2025-05-25
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}

