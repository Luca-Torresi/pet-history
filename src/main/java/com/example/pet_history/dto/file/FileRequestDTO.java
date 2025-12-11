package com.example.pet_history.dto.file;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class FileRequestDTO {
    @NotBlank
    private String type;
    private String description;
}
