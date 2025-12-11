package com.example.pet_history.dto.administration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class AdministrationRequestDTO {
    @NotBlank
    private String dosage;
    @NotBlank
    private String duration;
    @NotNull
    private Long medicationId;
}

