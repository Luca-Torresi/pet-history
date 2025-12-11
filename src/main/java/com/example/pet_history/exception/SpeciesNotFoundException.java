package com.example.pet_history.exception;

public class SpeciesNotFoundException extends RuntimeException {
    public SpeciesNotFoundException(Long id) {
        super("No se encontró la especie con el ID: ");
    }
}
