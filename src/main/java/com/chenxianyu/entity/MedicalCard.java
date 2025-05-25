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

    private Long id;

    private Integer cardId;

    private String fullName;

    private String medlicalName;

    private LocalDate startTime;

    private LocalDate endTime;
}
