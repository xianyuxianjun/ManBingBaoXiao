package com.chenxianyu.controller;

import ch.qos.logback.core.util.StringUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenxianyu.entity.Reimbursement;
import com.chenxianyu.entity.Reslut;
import com.chenxianyu.service.IReimbursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        Page<Reimbursement> page = reimbursementService.lambdaQuery()
                .like(StringUtil.notNullNorEmpty(fullName), Reimbursement::getFullName, fullName)
                .eq(StringUtil.notNullNorEmpty(medicalName), Reimbursement::getMedicalName, medicalName)
                .eq(StringUtil.notNullNorEmpty(invoiceNo), Reimbursement::getInvoiceNo, invoiceNo)
                .eq(StringUtil.notNullNorEmpty(isReimbursement), Reimbursement::getIsReimbursement, isReimbursement)
                .eq(StringUtil.notNullNorEmpty(isRemit), Reimbursement::getIsRemit, isRemit)
                .page(new Page<>(current, size));

        return Reslut.Success(page);
    }

    @PostMapping("/save")
    public Reslut save(@RequestBody Reimbursement reimbursement){
        boolean isSuccess = reimbursementService.save(reimbursement);
        if (!isSuccess) {
            return Reslut.Fail("保存失败");
        }
        return Reslut.Success();

    }

    @PostMapping("/update")
    public Reslut update(@RequestBody Reimbursement reimbursement){
        boolean isSuccess = reimbursementService.updateById(reimbursement);
        if (!isSuccess) {
            return Reslut.Fail("修改失败");
        }
        return Reslut.Success();
    }

    @DeleteMapping("/delete/{reimbursementId}")
    public Reslut delete(@PathVariable Long reimbursementId){
        boolean isSuccess = reimbursementService.removeById(reimbursementId);
        if (!isSuccess) {
            return Reslut.Fail("删除失败");
        }
        return Reslut.Success();
    }

    @GetMapping("/get/{reimbursementId}")
    public Reslut get(@PathVariable Long reimbursementId){
        Reimbursement reimbursement = reimbursementService.getById(reimbursementId);
        return Reslut.Success(reimbursement);
    }
}
