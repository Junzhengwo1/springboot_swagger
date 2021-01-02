package com.kou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


/**
 * @author JIAJUN KOU
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 配置了Swagger的Docket的bean实例
     * @return
     */
    @Bean
    public Docket docket(Environment environment){

        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev");

        //获取醒目的环境；在这里就是获取生产环境
        boolean flag = environment.acceptsProfiles(profiles);//true

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kou.controller"))//指定区扫描这个包
                //.paths(PathSelectors.ant(""))//过滤路径
                .build();
    }

    private ApiInfo apiInfo(){

        Contact contact = new Contact("kou","htttps://baidu.com","2627084538@qq.com");

        return new ApiInfo(
                "kou Swagger Api",
                "api 就是前端要调用的东西。",
                "1.0",
                "urn:tos",
                 contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }


}
