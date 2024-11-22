package ca.gbc.inventoryservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class OpenApiConfig {



    @Value("${inventory-service.version}")
    private String version;

    @Bean
    public OpenAPI productServiceAPI(){

        return new OpenAPI()
                .info(new Info().title("Inventory Service API")
                        .description("This is the rets API for inventory service")
                        .version(version)
                        .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Inventory Service Wiki Documentation")
                        .url("https://myCompany.ca/inventory-service/docs"));
    }


}