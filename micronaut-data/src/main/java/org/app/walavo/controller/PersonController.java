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
import javax.validation.Valid;

@Validated
@Controller("/api/v1/persons")
public class PersonController {

    @Inject
    private ProductService productService;

    @Operation(summary = "Create Persons",
            description = "Create persons in the data base"
    )
    @ApiResponse(content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Invalid Name Supplied")
    @ApiResponse(responseCode = "404", description = "Person not found")
    @Tag(name = "persons")
    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<?> save(@Valid @Body Person person) throws Exception {
        return HttpResponse.status(HttpStatus.CREATED)
                .body(productService.savePerson(person));
    }

    @Operation(summary = "Update Persons",
            description = "Update persons in the data base"
    )
    @ApiResponse(content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Invalid Name Supplied")
    @ApiResponse(responseCode = "404", description = "Person not found")
    @Tag(name = "persons")
    @Put(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<?> update(@Valid @Body Person person) throws Exception {
        return HttpResponse.status(HttpStatus.OK)
                .body(productService.updatePerson(person));
    }

    @Operation(summary = "Delete Persons",
            description = "Delete persons in the data base"
    )
    @ApiResponse(content = @Content(mediaType = "application/json"))
    @ApiResponse(responseCode = "400", description = "Invalid Name Supplied")
    @ApiResponse(responseCode = "404", description = "Person not found")
    @Tag(name = "persons")
    @Delete(value = "/{id}",consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<?> delete(@PathVariable("id") Long id) throws Exception {
        return HttpResponse.status(HttpStatus.OK)
                .body(productService.deletePerson(id));
    }

    @Operation(summary = "Found Persons",
            description = "Found all persons in the data base"
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

    @Operation(summary = "Found Persons by ID",
            description = "Found persons by ID in the data base"
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
