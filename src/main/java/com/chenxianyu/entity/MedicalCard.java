package com.chenxianyu.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
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
@TableName("medical_card")
public class MedicalCard implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 身份证号
     */
    private Integer cardId;

    /**
     * 姓名
     */
    private String fullName;

    /**
     * 疾病名称
     */
    private String medlicalName;

    /**
     * 参保开始时间
     */
    private LocalDate startTime;

    /**
     * 参保结束时间
     */
    private LocalDate endTime;
}
