package com.example.pet_history.dto.pet;

import com.example.pet_history.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PetRequestDTO {
    @NotBlank
    private String name;
    @NotNull
    private LocalDate birthDate;
    @NotNull
    private Gender gender;
    @NotNull
    private Long idBreed;
}
