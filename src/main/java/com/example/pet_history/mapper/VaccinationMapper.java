package com.example.pet_history.mapper;

import com.example.pet_history.dto.vaccination.VaccinationRequestDTO;
import com.example.pet_history.dto.vaccination.VaccinationResponseDTO;
import com.example.pet_history.entity.Vaccination;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface VaccinationMapper {

    Vaccination toEntity(VaccinationRequestDTO dto);

    @Mapping(source = "vaccine.name", target = "vaccine")
    VaccinationResponseDTO toDto(Vaccination entity);

    void updateFromDto(VaccinationRequestDTO dto, @MappingTarget Vaccination entity);
}
