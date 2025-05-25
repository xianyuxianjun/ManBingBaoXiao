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
public class Medical implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 慢性病名称
     */
    private String name;

    /**
     * 慢性病编码
     */
    private String code;
}
