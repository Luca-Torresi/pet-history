package com.example.pet_history.dto.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class FileResponseDTO {
    private Long id;
    private String fileName;
    private String storageUrl;
    private String type;
    private String description;
}
