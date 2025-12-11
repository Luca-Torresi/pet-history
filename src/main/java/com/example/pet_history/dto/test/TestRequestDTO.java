package com.example.pet_history.dto.test;

import com.example.pet_history.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class TestRequestDTO {
    @NotBlank
    private String name;
    private String results;
    private LocalDate testDate;
    @NotNull
    private Status status;
}
