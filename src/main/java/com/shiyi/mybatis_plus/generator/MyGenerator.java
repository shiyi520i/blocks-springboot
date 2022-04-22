package com.shiyi.mybatis_plus.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;

import java.util.Collections;

/**
 * 自动生成类
 *
 * @author ：ShiYI
 * @date ：Created in 2021/9/28
 */
public class MyGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create(
                new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/recruitment?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC","root","123456")
                        .dbQuery(new MySqlQuery())
                        .schema("mybatis-plus")
                        .typeConvert(new MySqlTypeConvert())
                        .keyWordsHandler(new MySqlKeyWordsHandler())
                )
                .globalConfig(builder -> {
                    builder.author("ShiYi") // 设置作者
                            .disableOpenDir()//禁止打开输出目录
                            .enableSwagger() // 开启 swagger 模式
                            //.fileOverride() // 覆盖已生成文件
                            .outputDir(System.getProperty("user.dir")+"/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.shiyi.mybatis_plus") // 设置父包名
                            //.moduleName("sys")
                            .entity("pojo")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .xml("mapper.xml")
                            .controller("controller")
                            //.other("other")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir")+"/src/main/resources/mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_sys_userrole") // 设置需要生成的表名
                            .addTablePrefix("t_bus", "t_sys") // 设置过滤表前缀
                            .entityBuilder() //实体类配置
                            .enableLombok()
                            .enableTableFieldAnnotation()//实体类字段注解
                            .controllerBuilder()//controller配置
                            .enableRestStyle()//开启restcontroller
                            .mapperBuilder()
                            .enableMapperAnnotation()//开启mapper注解
                            .enableBaseResultMap()//启用 BaseResultMap 生成
                            .enableBaseColumnList();//启用 BaseColumnList

                })
                //.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
