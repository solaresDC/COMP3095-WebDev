package ca.gbc.orderservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class OpenApiConfig {


    @Value("${product-service.version}")
    private String version;

    @Bean
    public OpenAPI productServiceAPI(){

        return new OpenAPI().info(new Info().title("Order Service API")
                        .description("This is the REST API for Order service")
                        .version(version)
                        .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Order Service Confluence Documentation")
                        .url("https://myCompany.ca/inventoryservice/docs"));
    }

}
