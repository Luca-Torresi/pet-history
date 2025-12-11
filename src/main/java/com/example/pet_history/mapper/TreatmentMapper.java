package com.example.pet_history.mapper;

import com.example.pet_history.dto.treatment.TreatmentRequestDTO;
import com.example.pet_history.dto.treatment.TreatmentResponseDTO;
import com.example.pet_history.entity.Treatment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {AdministrationMapper.class})
public interface TreatmentMapper {

    Treatment toEntity(TreatmentRequestDTO dto);

    void updateFromDto(TreatmentRequestDTO dto, @MappingTarget Treatment entity);

    TreatmentResponseDTO toDto(Treatment entity);
}
