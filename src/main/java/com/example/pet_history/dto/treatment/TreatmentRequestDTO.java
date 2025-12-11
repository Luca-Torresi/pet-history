package com.example.pet_history.dto.treatment;

import com.example.pet_history.dto.administration.AdministrationRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class TreatmentRequestDTO {
    @NotBlank
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    @Valid
    private List<AdministrationRequestDTO> administrations;
}
