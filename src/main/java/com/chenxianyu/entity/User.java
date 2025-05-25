package com.chenxianyu.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * <p>
 * 
 * </p>
 *
 * @author chenxianyu
 * @since 2025-05-25
 */
@Getter
@Setter
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String fullName;

    /**
     * 角色
     */
    private String role;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String gender;
}
