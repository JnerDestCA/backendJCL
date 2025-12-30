package com.pryx.backendJCL.repository;

import com.pryx.backendJCL.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
    Optional<Empleado> findByUsername(String username);
    List<Empleado> findByEstado(boolean estado);
}
