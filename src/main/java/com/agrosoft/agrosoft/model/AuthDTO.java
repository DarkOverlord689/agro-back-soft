package com.agrosoft.agrosoft.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AuthDTO {
    private Long id;
    private String token;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String correo;
    private String telefono;
}
