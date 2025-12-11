package com.example.pet_history.dto.record;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class MedicalRecordRequestDTO {
    @NotBlank
    private String reasonForVisit;
    @NotBlank
    private String notes;
    private LocalDate date;

}
