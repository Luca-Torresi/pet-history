package com.example.pet_history.exception;

public class VaccinationNotFoundException extends RuntimeException {
    public VaccinationNotFoundException(Long id) {
        super("No se encontró la vacunación con el ID: " + id);
    }
}
