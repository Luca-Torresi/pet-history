package com.example.pet_history.exception;

public class MedicationNotFoundException extends RuntimeException {
    public MedicationNotFoundException(Long id) {
        super("No se encontró el medicamento con el ID: ");
    }
}
