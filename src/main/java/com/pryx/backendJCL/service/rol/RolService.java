package com.pryx.backendJCL.service.rol;

import com.pryx.backendJCL.exceptions.RolNotFoundException;
import com.pryx.backendJCL.model.Rol;
import com.pryx.backendJCL.repository.RolRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class RolService implements IRolService{
    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public Set<Rol> getRolesByNombres(Set<String> nombresRol) {
        Set<Rol> roles = rolRepository.findByNombreRol(nombresRol);

        if (roles.isEmpty() && !nombresRol.isEmpty()) {
            throw new RolNotFoundException("Ninguno de los roles fue encontrado");
        }

        return roles;
    }

    @Override
    public List<Rol> getAllRoles() {
        return rolRepository.findAll();
    }
}
