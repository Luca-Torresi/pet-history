package com.example.pet_history.exception;

public class TestNotFoundException extends RuntimeException {
    public TestNotFoundException(Long id) {
        super("No se encontró el test con el ID: " + id);
    }
}
