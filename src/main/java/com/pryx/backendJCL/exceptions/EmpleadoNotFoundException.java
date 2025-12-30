package com.pryx.backendJCL.exceptions;

public class EmpleadoNotFoundException extends RuntimeException {
    public EmpleadoNotFoundException(String message){
        super(message);
    }
}
