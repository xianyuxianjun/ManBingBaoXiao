package com.chenxianyu.controller;

import ch.qos.logback.core.util.StringUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenxianyu.entity.Medical;
import com.chenxianyu.entity.Reslut;
import com.chenxianyu.service.IMedicalService;
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
@RequestMapping("/medical")
public class MedicalController {

    @Autowired
    private IMedicalService medicalService;

    /**
     * 分页查询慢病信息
     * @param current 当前页
     * @param size 每页大小
     * @param name  名称
     * @param code 编码
     * @return
     */
    @GetMapping("/list")
    public Reslut list(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String code
    ){
        Page<Medical> page = new Page<>(current, size);
        LambdaQueryWrapper<Medical> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtil.notNullNorEmpty(name), Medical::getName, name);
        queryWrapper.eq(StringUtil.notNullNorEmpty(code), Medical::getCode, code);
        Page<Medical> medicalPage = medicalService.page(page, queryWrapper);
        return Reslut.Success(medicalPage);
    }

    /**
     * 保存慢病信息
     * @param medical 慢病信息
     * @return
     */
    @PostMapping("/save")
    public Reslut save(@RequestBody Medical medical) {
        boolean isSuccess = medicalService.save(medical);
        if (isSuccess) {
            return Reslut.Success();
        } else {
            return Reslut.Fail("保存失败");
        }
    }

    /**
     * 更新慢病信息
     * @param medical 慢病信息
     * @return
     */
    @PostMapping("/update")
    public Reslut update(@RequestBody Medical medical) {
        boolean isSuccess = medicalService.updateById(medical);
        if (isSuccess) {
            return Reslut.Success();
        } else {
            return Reslut.Fail("更新失败");
        }
    }

    /**
     * 删除慢病信息
     * @param medicalId 慢病信息ID
     * @return
     */
    @DeleteMapping("/delete/{medicalId}")
    public Reslut delete(@PathVariable Long medicalId) {
        boolean isSuccess = medicalService.removeById(medicalId);
        if (isSuccess) {
            return Reslut.Success();
        } else {
            return Reslut.Fail("删除失败");
        }
    }

}
