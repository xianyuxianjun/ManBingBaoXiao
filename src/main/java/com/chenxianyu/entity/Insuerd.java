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
public class Insuerd implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 姓名
     */
    private String fullName;

    /**
     * 身份证号
     */
    private String cardId;

    /**
     * 性别
     */
    private String gender;

    /**
     * 民族
     */
    private String nation;

    /**
     * 地址
     */
    private String address;

    /**
     * 联系电话
     */
    private String phone;
}
