package com.example.pet_history.dto.test;

import com.example.pet_history.dto.file.FileResponseDTO;
import com.example.pet_history.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class TestResponseDTO {
    private Long id;
    private String name;
    private String results;
    private LocalDate testDate;
    private Status status;
    private List<FileResponseDTO> files;
}
