package com.chenxianyu.controller;

import ch.qos.logback.core.util.StringUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenxianyu.entity.Insuerd;
import com.chenxianyu.entity.MedicalCard;
import com.chenxianyu.entity.Reslut;
import com.chenxianyu.service.IMedicalCardService;
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
@RequestMapping("/medicalCard")
public class MedicalCardController {

    @Autowired
    private IMedicalCardService medicalCardService;

    /**
     * 分页查询参合信息
     * @param current 当前页
     * @param size 每页大小
     * @param fullName 姓名
     * @param cardId 身份证号
     * @param medlicalName 疾病名称
     * @return
     */
    @GetMapping("/list")
    public Reslut list(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String fullName,
            @RequestParam(required = false) String cardId,
            @RequestParam(required = false) String medlicalName
    ){
        Page<MedicalCard> page = medicalCardService.lambdaQuery()
                .like(StringUtil.notNullNorEmpty(fullName), MedicalCard::getFullName, fullName)
                .eq(StringUtil.notNullNorEmpty(cardId), MedicalCard::getCardId, cardId)
                .eq(StringUtil.notNullNorEmpty(medlicalName), MedicalCard::getMedlicalName, medlicalName)
                .page(new Page<>(current, size));

        return Reslut.Success(page);
    }

    /**
     * 保存参合信息
     * @param medicalCard 参合信息
     * @return
     */
    @PostMapping("/save")
    public Reslut save(@RequestBody MedicalCard medicalCard) {
        boolean isSuccess = medicalCardService.save(medicalCard);
        if (isSuccess) {
            return Reslut.Success();
        } else {
            return Reslut.Fail("保存失败");
        }
    }

    /**
     * 更新参合信息
     */
    @PostMapping("/update")
    public Reslut update(@RequestBody MedicalCard medicalCard) {
        boolean isSuccess = medicalCardService.updateById(medicalCard);
        if (isSuccess) {
            return Reslut.Success();
        } else {
            return Reslut.Fail("更新失败");
        }
    }

    /**
     * 删除参合信息
     * @param medicalCardId 参合信息ID
     * @return
     */
    @DeleteMapping("/delete/{medicalCardId}")
    public Reslut delete(@PathVariable Integer medicalCardId) {
        boolean isSuccess = medicalCardService.removeById(medicalCardId);
        if (isSuccess) {
            return Reslut.Success();
        } else {
            return Reslut.Fail("删除失败");
        }
    }

    /**
     * 查询参合信息
     * @param medicalCardId 参合信息ID
     * @return
     */
    @GetMapping("/get/{medicalCardId}")
    public Reslut getMedicalCard(@PathVariable Integer medicalCardId) {
        MedicalCard medicalCard = medicalCardService.getById(medicalCardId);
        if (medicalCard == null) {
            return Reslut.Fail("参合信息不存在");
        }
        return Reslut.Success(medicalCard);
    }
}
