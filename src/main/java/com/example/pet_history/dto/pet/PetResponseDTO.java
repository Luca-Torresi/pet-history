package com.example.pet_history.dto.pet;

import com.example.pet_history.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PetResponseDTO {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private String species;
    private String breed;
}
