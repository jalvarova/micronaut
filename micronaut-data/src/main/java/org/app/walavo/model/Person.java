package org.app.walavo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Introspected
@Entity
@Table(name = "persons")
@Schema(name = "PersonModel", description = "Person Manager")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Schema(description = "Person name", maximum = "20", required = true, example = "Alvaro daniel")
    @NotEmpty(message = "Can not be empty")
    @Size(min = 1, max = 20)
    private String name;

    @Schema(description = "Person name", maximum = "20", required = true, example = "Aguinaga Delgado")
    @NotEmpty(message = "Can not be empty")
    @Size(min = 1, max = 20)
    private String lastName;

    @Min(18)
    @Schema(description = "Person age", maximum = "18", required = true, example = "29")
    private Integer age;

    @Schema(description = "Person telephone", maximum = "10", required = true, example = "985898787")
    @NotEmpty(message = "Can not be empty")
    @Size(min = 1, max = 10)
    private String telephone;

    @Schema(description = "Person document", maximum = "12", required = true, example = "47856344")
    @NotEmpty(message = "Can not be empty")
    @Size(min = 1, max = 12)
    @Column(unique = true)
    private String document;

    @Schema(description = "Person email", required = true, example = "alvaro@gmail.com")
    @NotEmpty(message = "Can not be empty")
    @Email(message = "Email not correct")
    private String email;

    @Schema(description = "Person address", required = true, maximum = "200", example = "CALLE SAN MIGUEL 222")
    @NotEmpty(message = "Can not be empty")
    @Size(min = 1, max = 200)
    private String address;

    @Schema(description = "Person birthDate", required = true, example = "1992-03-27")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Schema(description = "Person gender", required = true)
    private Gender gender;

    public static Person instance() {
        return new Person();
    }
}
