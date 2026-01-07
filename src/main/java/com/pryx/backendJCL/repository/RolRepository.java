package com.pryx.backendJCL.repository;

import com.pryx.backendJCL.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Set<Rol> findByNombreRol(Set<String> NombreRol);

    java.util.Optional<Rol> findByNombreRol(String nombreRol);
}
