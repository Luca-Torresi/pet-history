package com.example.pet_history.exception;

public class TreatmentNotFoundException extends RuntimeException {
    public TreatmentNotFoundException(Long id) {
        super("No se encontró el tratamiento con el ID: ");
    }
}
