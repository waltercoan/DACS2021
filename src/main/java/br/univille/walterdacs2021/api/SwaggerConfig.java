package br.univille.walterdacs2021.api;

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
    public Docket api2() { 
        return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("br.univille.walterdacs2021.api"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo());       
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("REST API")
        .description("Exemplo de Documentação da API.").termsOfServiceUrl("")
        .contact(new Contact("UNIVILLE", "", "univille@univille.br"))
        .license("Apache License Version 2.0")
        .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
        .version("0.0.1")
        .build();
    }
}
