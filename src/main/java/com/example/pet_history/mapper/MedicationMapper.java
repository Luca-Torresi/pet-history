package com.example.pet_history.mapper;

import com.example.pet_history.dto.medication.MedicationRequestDTO;
import com.example.pet_history.dto.medication.MedicationResponseDTO;
import com.example.pet_history.entity.Medication;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MedicationMapper {
    Medication toEntity(MedicationRequestDTO dto);
    MedicationResponseDTO toDto(Medication medication);

    void updateFromDto(MedicationRequestDTO dto, @MappingTarget Medication entity);
}
