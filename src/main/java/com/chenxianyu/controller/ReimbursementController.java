package com.chenxianyu.controller;

import com.chenxianyu.entity.Reslut;
import com.chenxianyu.service.IReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenxianyu
 * @since 2025-05-25
 */
@RestController
@RequestMapping("/reimbursement")
public class ReimbursementController {

    @Autowired
    private IReimbursementService reimbursementService;

    /**
     * @param current 当前页
     * @param size 每页大小
     * @param fullName 姓名
     * @param medicalName 疾病名称
     * @param invoiceNo 发票号
     * @param isReimbursement 是否报销
     * @param isRemit 是否汇款
     * @return
     */
    @GetMapping("/list")
    public Reslut list(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String medicalName,
            @RequestParam(required = false) String invoiceNo,
            @RequestParam(required = false) String isReimbursement,
            @RequestParam(required = false) String isRemit
    ){

    }

}
