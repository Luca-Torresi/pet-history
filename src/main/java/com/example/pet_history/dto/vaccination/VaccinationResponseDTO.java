package com.example.pet_history.dto.vaccination;

import com.example.pet_history.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class VaccinationResponseDTO {
    private Long id;
    private LocalDate applicationDate;
    private String lotNumber;
    private String vaccine;
    private Status status;
}
