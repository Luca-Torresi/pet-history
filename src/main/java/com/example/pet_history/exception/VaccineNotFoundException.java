package com.example.pet_history.exception;

public class VaccineNotFoundException extends RuntimeException {
    public VaccineNotFoundException(Long id) {
        super("No se encontró la vacuna con el ID: ");
    }
}
