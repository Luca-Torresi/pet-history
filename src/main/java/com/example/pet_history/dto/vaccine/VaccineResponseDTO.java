package com.example.pet_history.dto.vaccine;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class VaccineResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String manufacturer;
}
