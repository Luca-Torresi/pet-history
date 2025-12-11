package com.example.pet_history.dto.species;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class SpeciesRequestDTO {
    private String name;
}
