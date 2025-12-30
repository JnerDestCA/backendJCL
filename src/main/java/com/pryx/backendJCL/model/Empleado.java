package com.pryx.backendJCL.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "empleados")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empleado implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String appa;
    private String apma;

    @Column(unique = true)
    private String email;

    private String celular;
    private String dni;
    private Date fecha_ingreso;
    private Date fecha_salida;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean estado = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "empleado_rol", // Tu tabla intermedia
            joinColumns = @JoinColumn(name = "id_empleado"),
            inverseJoinColumns = @JoinColumn(name = "id_rol")
    )
    private Set<Rol> roles = new HashSet<>();

    public Empleado(String nombre, String appa, String apma, String email, String celular, String dni, Date fecha_ingreso, String username, String password, Set<Rol> roles) {
        this.nombre = nombre;
        this.appa = appa;
        this.apma = apma;
        this.email = email;
        this.celular = celular;
        this.dni = dni;
        this.fecha_ingreso = fecha_ingreso;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return estado;
    }
}
