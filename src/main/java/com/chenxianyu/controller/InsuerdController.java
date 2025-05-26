package com.chenxianyu.controller;

import ch.qos.logback.core.util.StringUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenxianyu.entity.Insuerd;
import com.chenxianyu.entity.Reslut;
import com.chenxianyu.service.IInsuerdService;
import org.apache.ibatis.annotations.Insert;
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
@RequestMapping("/insuerd")
public class InsuerdController {

    @Autowired
    private IInsuerdService insuerdService;

    /**
     * 分页查询病人信息
     * @param current 当前页
     * @param size 每页大小
     * @param fullName 姓名
     * @param cardId 身份证号
     * @param phone 手机号
     * @param gender 性别
     * @return
     */
    @GetMapping("/list")
    public Reslut list(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String cardId,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String gender
    ){
        Page<Insuerd> page = insuerdService.lambdaQuery().like(StringUtil.notNullNorEmpty(fullName), Insuerd::getFullName, fullName)
                .eq(StringUtil.notNullNorEmpty(cardId), Insuerd::getCardId, cardId)
                .eq(StringUtil.notNullNorEmpty(phone), Insuerd::getPhone, phone)
                .eq(StringUtil.notNullNorEmpty(gender), Insuerd::getGender, gender)
                .page(new Page<>(current, size));

        return Reslut.Success(page);
    }

    /**
     * 保存病人信息
     * @param insuerd 病人信息
     * @return
     */
    @PostMapping("/save")
    public Reslut save(@RequestBody Insuerd insuerd) {
        boolean isSuccess = insuerdService.save(insuerd);
        if (isSuccess) {
            return Reslut.Success();
        } else {
            return Reslut.Fail("保存失败");
        }
    }

    /**
     * 更新病人信息
     * @param insuerd 病人信息
     * @return
     */
    @PostMapping("/update")
    public Reslut update(@RequestBody Insuerd insuerd) {
        boolean isSuccess = insuerdService.updateById(insuerd);
        if (isSuccess) {
            return Reslut.Success();
        } else {
            return Reslut.Fail("更新失败");
        }
    }

    /**
     * 删除病人信息
     * @param insuerdId 病人ID
     * @return
     */
    @DeleteMapping("/delete/{insuerdId}")
    public Reslut delete(@PathVariable Long insuerdId) {
        boolean isSuccess = insuerdService.removeById(insuerdId);
        if (isSuccess) {
            return Reslut.Success();
        } else {
            return Reslut.Fail("删除失败");
        }
    }

    /**
     * 查询病人信息
     * @param insuerdId 病人ID
     * @return
     */
    @GetMapping("/get/{insuerdId}")
    public Reslut getInsuerd(@PathVariable Long insuerdId) {
        Insuerd insuerd = insuerdService.getById(insuerdId);
        if (insuerd == null) {
            return Reslut.Fail("病人不存在");
        }
        return Reslut.Success(insuerd);
    }

}
