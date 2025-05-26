package com.chenxianyu.controller;

import com.chenxianyu.service.IMedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/medicalCard")
public class MedicalCardController {

    @Autowired
    private IMedicalCardService medicalCardService;
}
