package com.example.pet_history.dto.medication;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class MedicationRequestDTO {
    private String brandName;
    private String description;
    private String activeIngredient;
    private String manufacturer;
}
