package com.shiyi.mybatis_plus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * swagger
 *
 * @author ：ShiYI
 * @date ：Created in 2021/9/28
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .groupName("")  //分组名称，可以通过配置多个bean来达到分组效果
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shiyi.mybatis_plus.controller")) // 设置扫描路径
                //.paths(PathSelectors.ant("/*")) 过滤mapping为"/"的所有路径
                .build();
    }
    //信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Api V1")
                .contact(new Contact("", "", ""))
                .version("1")
                .build();
    }
}

