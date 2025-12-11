package com.example.pet_history.dto.administration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class AdministrationResponseDTO {
    private String dosage;
    private String duration;
    private String brandName;
}
