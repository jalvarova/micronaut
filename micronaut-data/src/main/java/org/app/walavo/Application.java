package org.app.walavo;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;


@OpenAPIDefinition(
        info = @Info(
                title = "Api de Personas",
                version = "1.0.0",
                description = "Person API",
                license = @License(name = "Apache 2.0", url = "https://walavo.tk"),
                contact = @Contact(url = "https://gigantic-server.com", name = "Alvaro Aguinaga", email = "alvaro@gmail.com")
        ),
        servers = {
                @Server(url = "http://localhost:9080", description = "Server Local"),
                @Server(url = "http://walavo.tk", description = "Server Dev")
        }
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
