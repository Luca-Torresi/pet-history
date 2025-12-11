package com.example.pet_history.exception;

public class MedicalRecordNotFoundException extends RuntimeException {
    public MedicalRecordNotFoundException(Long id) {
        super("No se encontró el registro médico con el ID: ");
    }
}
