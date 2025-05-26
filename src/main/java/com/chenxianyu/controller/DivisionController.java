package com.chenxianyu.controller;

import ch.qos.logback.core.util.StringUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenxianyu.entity.Division;
import com.chenxianyu.entity.Insuerd;
import com.chenxianyu.entity.Reslut;
import com.chenxianyu.service.IDivisionService;
import com.chenxianyu.vo.DivisionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenxianyu
 * @since 2025-05-25
 */
@RestController
@RequestMapping("/division")
public class DivisionController {

    @Autowired
    private IDivisionService divisionService;

    /**
     * 分页查询行政区划
     * @param current 当前页
     * @param size 每页大小
     * @param name 名称
     * @param level 级别
     * @return 分页结果
     */
    @GetMapping("/list")
    public Reslut list(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String level
            ){
        LambdaQueryWrapper<Division> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtil.notNullNorEmpty(name),Division::getName,name);
        queryWrapper.like(StringUtil.notNullNorEmpty(level),Division::getLevel,level);
        Page<Division> page = new Page<>(current, size);
        Page<Division> divisionPage = divisionService.page(page, queryWrapper);
        List<DivisionVo> divisionVoList = divisionPage.getRecords().stream()
                .map(division -> {
                    DivisionVo divisionVo = new DivisionVo();
                    divisionVo.setId(division.getId());
                    divisionVo.setLevel(division.getLevel());
                    if (division.getParent()==0){
                        divisionVo.setName(division.getName());
                    }else {
                        Division prantDivison = divisionService.lambdaQuery().eq(Division::getId, division.getParent()).one();
                        divisionVo.setName(prantDivison.getName() + " - " + division.getName());

                    }
                    return divisionVo;
                }).toList();
        Page<DivisionVo> divisionVoPage = new Page<>(current, size);
        divisionVoPage.setRecords(divisionVoList);
        divisionVoPage.setTotal(divisionPage.getTotal());
        return Reslut.Success(divisionVoPage);

    }

    /**
     * 查询所有父级行政区划
     */
    @GetMapping("/parent")
    public Reslut parent() {
        LambdaQueryWrapper<Division> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Division::getParent, 0);
        List<Division> divisions = divisionService.list(queryWrapper);
        return Reslut.Success(divisions);
    }

    /**
     * 根据父级行政区划ID查询子级行政区划
     * @param parentId 父级行政区划ID
     * @return 子级行政区划列表
     */
    @GetMapping("/children/{parentId}")
    public Reslut children(@RequestParam Long parentId) {
        LambdaQueryWrapper<Division> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Division::getParent, parentId);
        List<Division> divisions = divisionService.list(queryWrapper);
        return Reslut.Success(divisions);
    }

    /**
     * 查询行政区划信息
     * @param divisionId 行政区划对象ID
     * @return 行政区划对象
     */
    @GetMapping("/get/{divisionId}")
    public Reslut get(@PathVariable Long divisionId) {
        Division division = divisionService.getById(divisionId);
        if (division == null) {
            return Reslut.Fail("行政区划不存在");
        }
        return Reslut.Success(division);
    }

    /**
     * 删除行政区划
     * @param divisionId 行政区划对象ID
     * @return 操作结果
     */
    @DeleteMapping("/delete/{divisionId}")
    public Reslut delete(@PathVariable Long divisionId) {
        boolean remove = divisionService.removeById(divisionId);
        if (!remove) {
            return Reslut.Fail("删除失败");
        }
        return Reslut.Success();
    }

    /**
     * 保存行政区划
     * @param division 行政区划对象
     * @return 操作结果
     */
    @PostMapping("/save")
    public Reslut save(@RequestBody Division division) {
        boolean save = divisionService.save(division);
        if (!save) {
            return Reslut.Fail("保存失败");
        }
        return Reslut.Success();
    }

    /**
     * 更新行政区划
     * @param division 行政区划对象
     * @return 操作结果
     */
    @PostMapping("/update")
    public Reslut update(@RequestBody Division division) {
        boolean update = divisionService.updateById(division);
        if (!update) {
            return Reslut.Fail("更新失败");
        }
        return Reslut.Success();
    }
}
