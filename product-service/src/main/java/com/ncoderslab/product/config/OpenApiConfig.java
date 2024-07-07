package com.ncoderslab.product.config;

import io.swagger.v3.core.util.Yaml;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Configuration
public class OpenApiConfig {

    private OpenAPI openAPI;

    @PostConstruct
    public void init() throws IOException {
        saveYamlFile();
    }

    private void saveYamlFile() throws IOException {
        String yaml = Yaml.pretty(openAPI);
        File yamlFile = new File("C:\\lab\\spring-boot-microservices\\openapi.yaml");
        if (!yamlFile.getParentFile().exists()) {
            yamlFile.getParentFile().mkdirs();  // Create directories if they don't exist
        }
        try (FileOutputStream fos = new FileOutputStream(yamlFile)) {
            fos.write(yaml.getBytes(StandardCharsets.UTF_8));
        }
    }

    @Bean
    public OpenAPI ProductServiceAPI() {
        this.openAPI = new OpenAPI()
                .info(new Info().title("Product Service API")
                        .description("This is the REST API for Product Service")
                        .version("V0.0.1")
                        .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("You can refer to the Product Service Wiki Documentations")
                        .url("https://github.com/ncoderslab/product-service"));
        return openAPI;
    }
}
