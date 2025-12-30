package com.pryx.backendJCL.service.empleado;

import com.pryx.backendJCL.model.Empleado;
import com.pryx.backendJCL.request.AddEmpleadoRequest;

import java.util.List;

public interface IEmpleadoService {
    Empleado addEmpleado(AddEmpleadoRequest request);
    Empleado getEmpleadoByUsername(String username);
    Empleado getEmpleadoById(Long id );
    void deleteEmpleadoById(Long id);
    void updateEmpleado(Empleado empleado, Long EmpleadoId);
    List<Empleado> getAllEmpleados();
    List<Empleado> getEmpleadosByEstado(boolean estado);
}
