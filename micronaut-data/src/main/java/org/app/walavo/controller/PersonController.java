package org.app.walavo.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.app.walavo.bussiness.ProductService;
import org.app.walavo.model.Person;

import javax.inject.Inject;

@Validated
@Controller("api/v1/persons")
public class PersonController {

    @Inject
    private ProductService productService;

    @Operation(summary = "Registrado de personas",
            description = "Registra personas en base de datos"
    )
    @ApiResponse(content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Invalid Name Supplied")
    @ApiResponse(responseCode = "404", description = "Person not found")
    @Tag(name = "persons")
    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<?> save(@Body Person person) throws Exception {
        return HttpResponse.status(HttpStatus.CREATED)
                .body(productService.savePerson(person));
    }

    @Operation(summary = "Actualiza de personas",
            description = "Actualiza personas en base de datos"
    )
    @ApiResponse(content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Invalid Name Supplied")
    @ApiResponse(responseCode = "404", description = "Person not found")
    @Tag(name = "persons")
    @Put(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<?> update(@Body Person person) throws Exception {
        return HttpResponse.status(HttpStatus.OK)
                .body(productService.updatePerson(person));
    }

    @Operation(summary = "Busqueda de personas",
            description = "Busqueda personas en base de datos"
    )
    @ApiResponse(content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Invalid Name Supplied")
    @ApiResponse(responseCode = "404", description = "Person not found")
    @Tag(name = "persons")
    @Get(produces = MediaType.APPLICATION_JSON)
    public HttpResponse<?> findAll() {
        return HttpResponse.status(HttpStatus.OK)
                .body(productService.findAllPersons());
    }

    @Operation(summary = "Busqueda de personas por ID",
            description = "Busqueda personas por ID en base de datos"
    )
    @ApiResponse(content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Invalid Name Supplied")
    @ApiResponse(responseCode = "404", description = "Person not found")
    @Tag(name = "persons")
    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<?> findById(@PathVariable("id") Long id) {
        return HttpResponse.status(HttpStatus.OK)
                .body(productService.findByIdPersons(id));
    }
}
