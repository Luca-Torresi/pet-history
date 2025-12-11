package com.example.pet_history.dto.species;

import com.example.pet_history.dto.breed.BreedResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class SpeciesResponseDTO {
    private Long id;
    private String name;
    private String imageUrl;
    private List<BreedResponseDTO> breeds;
}
