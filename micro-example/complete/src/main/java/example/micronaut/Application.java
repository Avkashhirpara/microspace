package example.micronaut;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@OpenAPIDefinition(
        info = @Info(
                title = "Application",
                version = "1.0",
                description = "Sample API",
                contact = @Contact(url = "Avkash.hirpara.com", name = "Avkash Hirpara", email = "Avkash.av1987@gmail.com")
        )
)
public class Application {


    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}