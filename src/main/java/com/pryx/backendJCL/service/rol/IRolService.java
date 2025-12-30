package com.pryx.backendJCL.service.rol;

import com.pryx.backendJCL.model.Rol;

import java.util.List;
import java.util.Set;

public interface IRolService {
    Set<Rol> getRolesByNombres(Set<String> NombreRol);
    List<Rol> getAllRoles();
}
