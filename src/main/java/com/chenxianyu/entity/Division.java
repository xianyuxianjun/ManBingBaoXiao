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
public class Division implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Id
     */
    private Long id;

    /**
     * 父ID
     */
    private Long parent;

    /**
     * 地区名
     */
    private String name;

    /**
     * 县城或者区镇
     */
    private String level;
}
