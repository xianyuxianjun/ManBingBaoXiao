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

    private Long id;

    private String fullName;

    private String medicalName;

    private String address;

    private String reimbursementAmount;

    private String totalTost;

    private Integer invoiceNo;

    private LocalDate date;

    private String isReimbursement;

    private String isRemit;
}
