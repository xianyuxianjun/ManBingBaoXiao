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
public class Policy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 年份
     */
    private String year;

    /**
     * 封顶线
     */
    private Double max;

    /**
     * 比例
     */
    private Double percentage;
}
