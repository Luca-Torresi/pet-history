package com.example.pet_history.exception;

public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException(Long id) {
        super("No se encontró la mascota con el ID: ");
    }
}
