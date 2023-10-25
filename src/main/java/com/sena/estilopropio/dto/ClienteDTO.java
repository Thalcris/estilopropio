package com.sena.estilopropio.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClienteDTO {

    private Long id;

    @NotBlank
    @Size(max = 300)
    private String nombre;

    @NotBlank
    @Size(max = 300)
    private String correo;

    @NotBlank
    @Size(max = 300)
    private String telefono;

    @NotBlank
    @Size(max = 300)
    private String password;

}
