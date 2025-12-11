package com.example.pet_history.dto.vaccination;

import com.example.pet_history.enums.Status;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class VaccinationRequestDTO {
    @NotNull
    private Long vaccineId;
    private LocalDate applicationDate;
    private String lotNumber;
    private Status status;
}
