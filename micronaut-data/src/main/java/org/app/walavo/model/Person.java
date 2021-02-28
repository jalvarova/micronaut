package org.app.walavo.model;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Introspected
@Entity
@Table(name = "persons")
@Schema(name = "PersonModel", description = "Person Manager")
public class Person {

    @Schema(description = "Person Id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Schema(description = "Person name", maximum = "20")
    @NotEmpty(message = "Can not be empty")
    @Size(min = 1, max = 20)
    private String name;

    @Min(18)
    @Schema(description = "Person age", maximum = "18")
    private Integer age;

    @Schema(description = "Person telephone", maximum = "10")
    @NotEmpty(message = "Can not be empty")
    @Size(min = 1, max = 10)
    private String telephone;

    public static Person instance() {
        return new Person();
    }
}
