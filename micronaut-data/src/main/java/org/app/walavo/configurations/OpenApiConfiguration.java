package org.app.walavo.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

import javax.inject.Singleton;

@OpenAPIDefinition(
        info = @Info(
                title = "Api de Personas",
                version = "1.0.0",
                description = "Person API",
                license = @License(name = "Apache 2.0", url = "https://walavo.tk"),
                contact = @Contact(url = "https://walavo.tk", name = "Alvaro Aguinaga", email = "alvaro@gmail.com")
        ),
        servers = {
                @Server(url = "http://localhost:9080", description = "Server Local"),
                @Server(url = "https://walavo-persons-gzn4kc6qva-uc.a.run.app", description = "Server Cloud Run")

        }
)

@Singleton
public class OpenApiConfiguration {
}
