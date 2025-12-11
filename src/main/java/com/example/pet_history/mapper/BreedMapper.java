package com.example.pet_history.mapper;

import com.example.pet_history.dto.breed.BreedRequestDTO;
import com.example.pet_history.dto.breed.BreedResponseDTO;
import com.example.pet_history.entity.Breed;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BreedMapper {

    Breed toEntity(BreedRequestDTO dto);

    @Mapping(source = "species.name", target = "speciesName")
    @Mapping(source = "species.id", target = "speciesId")
    BreedResponseDTO toDto(Breed entity);

    void updateFromDto(BreedRequestDTO dto, @MappingTarget Breed entity);

}
