package com.pryx.backendJCL.service;

import com.pryx.backendJCL.service.JwtService;
import com.pryx.backendJCL.model.Empleado;
import com.pryx.backendJCL.repository.EmpleadoRepository;
import com.pryx.backendJCL.request.AuthenticationRequest;
import com.pryx.backendJCL.request.RegisterRequest;
import com.pryx.backendJCL.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final EmpleadoRepository repository;
    private final com.pryx.backendJCL.repository.RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = new Empleado();
        user.setNombre(request.getNombre());
        user.setAppa(request.getAppa());
        user.setApma(request.getApma());
        user.setEmail(request.getEmail());
        user.setCelular(request.getCelular());
        user.setDni(request.getDni());
        user.setFecha_ingreso(request.getFecha_ingreso());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        var defaultRole = rolRepository.findByNombreRol("ROLE_USER")
                .or(() -> rolRepository.findByNombreRol("USER"))
                .orElse(null);
        if (defaultRole != null) {
            user.setRoles(java.util.Collections.singleton(defaultRole));
        }

        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()));
        var user = repository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
