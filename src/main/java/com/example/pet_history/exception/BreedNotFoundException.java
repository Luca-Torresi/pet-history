package com.example.pet_history.exception;

public class BreedNotFoundException extends RuntimeException {
    public BreedNotFoundException(Long id) {
        super("No se encontró la raza con el ID: " + id);
    }
}
