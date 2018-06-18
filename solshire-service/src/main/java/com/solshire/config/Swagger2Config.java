package com.solshire.config;

import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.SwaggerDefinition.Scheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 配置
 *
 * @author trang
 */
@Profile("dev")
@Configuration
@EnableSwagger2
@SwaggerDefinition(schemes = Scheme.HTTP, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .tags(new Tag("Admin","后台用户"),getTags())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.solshire.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private Tag[] getTags() {
        Tag[] tags = {
                new Tag("User", "用户相关API"),
                new Tag("Login", "后台登入相关接口"),
                new Tag("Riches","财富团队成员和注册用户模块"),
                new Tag("APPAd","网站编辑"),
                new Tag("Gen","上传文件等公共方法"),
                new Tag("Sales","销售管理")
        };
        return tags;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
//                .contact(new Contact("CC", "https://github.com/cc", "cc@hotmail.com"))
                .version("1.0")
                .build();
    }

}