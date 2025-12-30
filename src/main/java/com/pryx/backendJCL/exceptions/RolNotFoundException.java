package com.pryx.backendJCL.exceptions;

public class RolNotFoundException extends RuntimeException {
    public RolNotFoundException(String rolNoEncontrado) {
        super(rolNoEncontrado);
    }
}
