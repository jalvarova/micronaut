package org.ht.com.pe.web;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;

@Controller("/usAdvice")
public class UsAdviceRestController {

    @Get(uri = "/", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public String index() {
        return "Example Response";
    }

    @Post(uri = "/", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public String save() {
        return "Example Response";
    }
}