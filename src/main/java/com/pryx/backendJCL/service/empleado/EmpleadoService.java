package com.pryx.backendJCL.service.empleado;

import com.pryx.backendJCL.exceptions.EmpleadoNotFoundException;
import com.pryx.backendJCL.model.Empleado;
import com.pryx.backendJCL.model.Rol;
import com.pryx.backendJCL.repository.EmpleadoRepository;
import com.pryx.backendJCL.repository.RolRepository;
import com.pryx.backendJCL.request.AddEmpleadoRequest;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class EmpleadoService implements IEmpleadoService{
    private final EmpleadoRepository empleadoRepository;
    private final RolRepository rolRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository, RolRepository rolRepository) {
        this.empleadoRepository = empleadoRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    public Empleado addEmpleado(AddEmpleadoRequest request) {
        Set<Rol> rolesFound = rolRepository.findByNombreRol(request.getRoles());
        return empleadoRepository.save(createEmpleado(request,rolesFound));

    }

    public Empleado createEmpleado(AddEmpleadoRequest request, Set<Rol> roles) {
        return new Empleado(
                request.getNombre(),
                request.getAppa(),
                request.getApma(),
                request.getEmail(),
                request.getCelular(),
                request.getDni(),
                new Date(),
                request.getUsername(),
                request.getPassword(),
                roles
        );
    }

    @Override
    public Empleado getEmpleadoByUsername(String username) {
        return empleadoRepository.findByUsername(username)
                .orElseThrow(()->new EmpleadoNotFoundException("Empleado no encontrado"));
    }

    @Override
    public Empleado getEmpleadoById(Long id) {
        return empleadoRepository.findById(id)
                .orElseThrow(()->new EmpleadoNotFoundException("Empleado no encontrado"));
    }

    @Override
    public void deleteEmpleadoById(Long id) {

    }

    @Override
    public void updateEmpleado(Empleado empleado, Long EmpleadoId) {

    }

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public List<Empleado> getEmpleadosByEstado(boolean estado) {
        return empleadoRepository.findByEstado(estado);
    }
}
