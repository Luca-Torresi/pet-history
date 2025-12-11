package com.example.pet_history.mapper;

import com.example.pet_history.dto.species.SpeciesRequestDTO;
import com.example.pet_history.dto.species.SpeciesResponseDTO;
import com.example.pet_history.entity.Species;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {BreedMapper.class})
public interface SpeciesMapper {

    Species toEntity(SpeciesRequestDTO dto);

    SpeciesResponseDTO toDto(Species entity);

    void updateFromDto(SpeciesRequestDTO dto, @MappingTarget Species entity);
}
