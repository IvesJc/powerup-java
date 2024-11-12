package powerup.v1.infra;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI().
                info(new Info().
                        title("PowerUp - Java & Spring Boot 3").
                        version("v1").
                        description("Ellie de Oliveira\n" +
                                "\n" +
                                "RM: 552824\n" +
                                "\n" +
                                "Ives Jundi Chiba\n" +
                                "\n" +
                                "RM: 553243\n" +
                                "\n" +
                                "Nathalia Comeron Freire\n" +
                                "\n" +
                                "RM: 553233").
                        license(new License().
                                name("PowerUp").
                                url("https://www.fiap.com.br/")));
    }
}