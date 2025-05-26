package com.chenxianyu.controller;

import ch.qos.logback.core.util.StringUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenxianyu.entity.Policy;
import com.chenxianyu.entity.Reslut;
import com.chenxianyu.service.IPolicyService;
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
@RequestMapping("/policy")
public class PolicyController {

    @Autowired
    private IPolicyService policyService;

    /**
     * 分页查询核销政策
     * @param current
     * @param size
     * @param year
     * @return
     */
    @GetMapping("/list")
    public Reslut list(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String year
    ){
        Page<Policy> page = policyService.lambdaQuery()
                        .eq(StringUtil.notNullNorEmpty(year), Policy::getYear, year)
                        .page(new Page<>(current, size));

        return Reslut.Success(page);

    }

    /**
     * 保存核销政策
     * @param policy 核销政策信息
     * @return
     */
    @PostMapping("/save")
    public Reslut save(@RequestBody Policy policy) {
        boolean isSuccess = policyService.save(policy);
        if (isSuccess) {
            return Reslut.Success();
        } else {
            return Reslut.Fail("保存失败");
        }
    }

    /**
     * 更新核销政策
     * @param policy
     * @return
     */
    @PostMapping("/update")
    public Reslut update(@RequestBody Policy policy) {
        boolean isSuccess = policyService.updateById(policy);
        if (isSuccess) {
            return Reslut.Success();
        } else {
            return Reslut.Fail("更新失败");
        }
    }

    /**
     * 删除核销政策
     * @param policyId 核销政策ID
     * @return
     */
    @DeleteMapping("/delete/{policyId}")
    public Reslut delete(@PathVariable Long policyId) {
        boolean isSuccess = policyService.removeById(policyId);
        if (isSuccess) {
            return Reslut.Success();
        } else {
            return Reslut.Fail("删除失败");
        }
    }

    /**
     * 查询核销政策信息
     * @param policyId 核销政策ID
     * @return
     */
    @GetMapping("/get/{policyId}")
    public Reslut get(@PathVariable Long policyId) {
        Policy policy = policyService.getById(policyId);
        if (policy == null) {
            return Reslut.Fail("核销政策不存在");
        }
        return Reslut.Success(policy);
    }




}
