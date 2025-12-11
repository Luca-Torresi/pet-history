package com.example.pet_history.dto.treatment;

import com.example.pet_history.dto.administration.AdministrationResponseDTO;
import com.example.pet_history.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class TreatmentResponseDTO {
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;
    private List<AdministrationResponseDTO> administrations;
}
