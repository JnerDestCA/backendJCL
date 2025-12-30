package com.pryx.backendJCL.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class AddEmpleadoRequest {
    private String nombre;
    private String appa;
    private String apma;

    @Email(message = "Formato de email inválido")
    private String email;

    @Pattern(regexp = "\\d{9}", message = "El celular debe tener 9 dígitos")
    private String celular;

    @Size(min = 8, max = 8, message = "El DNI debe tener 8 caracteres")
    private String dni;
    private Date fecha_ingreso;
    private Date fecha_salida;

    private String username;

    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;

    // Recibimos solo los nombres de los roles (ej: ["ADMIN", "USER"])
    private Set<String> roles;
}
