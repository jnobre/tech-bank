package com.techbank.account.cmd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.techbank.account.cmd.api.controllers"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Tech Bank Account Commands").description("APIs responsible for bank account commands").termsOfServiceUrl("Terms of service").contact(
                new Contact("João Nobre","https://github.com/jnobre/client-java-api","joaoanobre@gmail.com")
        ).license("License of API").licenseUrl("https://swagger.io/docs/").version("1.0.0").build();
    }
}
