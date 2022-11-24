package br.com.velascoluan.formula1.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("RESTful CRUD Formula1 API")
                        .version("v1")
                        .description("F1 CRUD API")
                        .termsOfService("Https:pub.velascoluan.com.br/crud-f1/terms-of-services")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("Https:pub.velascoluan.com.br/crud-f1/licenses")));
    }
}
