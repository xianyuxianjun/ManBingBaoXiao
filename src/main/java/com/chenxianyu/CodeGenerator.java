package com.chenxianyu;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.ibatis.annotations.Mapper;

public class CodeGenerator {
    public static void main(String[] args) {
        // 使用 FastAutoGenerator 快速配置代码生成器  
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/manbing", "root", "123456cxy")
                .globalConfig(builder -> {
                    builder.author("chenxianyu") // 设置作者
                            .outputDir("src/main/java"); // 输出目录  
                })
                .packageConfig(builder -> {
                    builder.parent("com.chenxianyu") // 设置父包名
                            .entity("entity") // 设置实体类包名  
                            .mapper("mapper") // 设置 Mapper 接口包名  
                            .service("service") // 设置 Service 接口包名  
                            .serviceImpl("service.impl") // 设置 Service 实现类包名  
                            .xml("mappers"); // 设置 Mapper XML 文件包名  
                })
                .strategyConfig(builder -> {
                    builder.addInclude("division,insuerd,medical,medical_card,policy,reimbursement") // 设置需要生成的表名
                            .entityBuilder()
                            .enableLombok() // 启用 Lombok 注解，包括 @Data                            .enableTableFieldAnnotation() // 启用字段注解  
                            .mapperBuilder()
                            .mapperAnnotation(Mapper.class) // 启用 @Mapper 注解  
                            .controllerBuilder()
                            .enableRestStyle(); // 启用 REST 风格  
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用 Freemarker 模板引擎  
                .execute(); // 执行生成  
    }
}