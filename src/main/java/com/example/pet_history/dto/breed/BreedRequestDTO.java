package com.example.pet_history.dto.breed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class BreedRequestDTO {
    private String name;
    private Long speciesId;
}
