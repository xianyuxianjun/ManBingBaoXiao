package com.chenxianyu.entity;

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
public class Reimbursement implements Serializable {

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
     * 疾病名称
     */
    private String medicalName;

    /**
     * 居住地址
     */
    private String address;

    /**
     * 报销金额
     */
    private Double reimbursementAmount;

    /**
     * 总计
     */
    private Double totalTost;

    /**
     * 发票号
     */
    private String invoiceNo;

    /**
     * 报销时间
     */
    private LocalDate date;

    /**
     * 是否审核
     */
    private String isReimbursement;

    /**
     * 是否汇款
     */
    private String isRemit;
}
