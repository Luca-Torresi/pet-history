package com.example.pet_history.mapper;

import com.example.pet_history.dto.file.FileRequestDTO;
import com.example.pet_history.dto.file.FileResponseDTO;
import com.example.pet_history.entity.File;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FileMapper {

    File toEntity(FileRequestDTO dto);

    FileResponseDTO toDto(File file);

}
