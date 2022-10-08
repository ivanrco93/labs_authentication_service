package devforce.labs.authentication.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    private static final String SWAGGER_API_VERSION = "1.6.9";
    private static final String SWAGGER_API_TITLE = "1.6.9";
    private static final String SWAGGER_API_DESCRIPTION = "1.6.9";

    @Bean
    public OpenAPI authenticationOpenAPI(){
        return new OpenAPI()
                .info(new Info().title(SWAGGER_API_TITLE)
                        .description(SWAGGER_API_DESCRIPTION)
                        .version(SWAGGER_API_VERSION));
    }
}
