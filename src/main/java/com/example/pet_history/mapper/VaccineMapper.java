package com.example.pet_history.mapper;

import com.example.pet_history.dto.vaccine.VaccineRequestDTO;
import com.example.pet_history.dto.vaccine.VaccineResponseDTO;
import com.example.pet_history.entity.Vaccine;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VaccineMapper {
    Vaccine toEntity(VaccineRequestDTO dto);
    VaccineResponseDTO toDTO(Vaccine entity);

    void updateFromDTO(VaccineRequestDTO dto, @MappingTarget Vaccine entity);
}
