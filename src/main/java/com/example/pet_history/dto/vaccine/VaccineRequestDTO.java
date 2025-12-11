package com.example.pet_history.dto.vaccine;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class VaccineRequestDTO {
    @NotBlank
    private String name;
    private String description;
    private String manufacturer;
}
