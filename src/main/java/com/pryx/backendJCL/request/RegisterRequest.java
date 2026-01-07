package com.pryx.backendJCL.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String nombre;
    private String appa;
    private String apma;
    private String email;
    private String celular;
    private String dni;
    private Date fecha_ingreso;
    private String username;
    private String password;
}
