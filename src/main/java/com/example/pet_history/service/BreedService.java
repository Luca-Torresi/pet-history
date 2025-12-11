package com.example.pet_history.service;

import com.example.pet_history.dto.breed.BreedRequestDTO;
import com.example.pet_history.dto.breed.BreedResponseDTO;
import com.example.pet_history.entity.Breed;
import com.example.pet_history.entity.Species;
import com.example.pet_history.exception.BreedNotFoundException;
import com.example.pet_history.exception.SpeciesNotFoundException;
import com.example.pet_history.mapper.BreedMapper;
import com.example.pet_history.repository.BreedRepository;
import com.example.pet_history.repository.SpeciesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio para gestionar las distintas razas de las mascotas.
 * Provee métodos para crear, actualizar y obtener un listado con todas las razas cargadas.
 * Solo accesible para los administradores de la aplicación.
 */

@Service
@RequiredArgsConstructor
public class BreedService {
    private final BreedRepository breedRepository;
    private final BreedMapper breedMapper;
    private final SpeciesRepository speciesRepository;

    /**
     * Registra una nueva raza en el sistema.
     *
     * @param dto Objeto DTO con los datos para crear una nueva raza.
     * @return El DTO con la información de la raza recién creada.
     * @throws SpeciesNotFoundException Si no se encuentra la especie correspondiente a la raza.
     */

    public BreedResponseDTO newBreed(BreedRequestDTO dto) {
        Species species = speciesRepository.findById(dto.getSpeciesId()).orElseThrow(() -> new SpeciesNotFoundException(dto.getSpeciesId()));

        Breed breed = breedMapper.toEntity(dto);
        breed.setSpecies(species);
        breedRepository.save(breed);

        return breedMapper.toDto(breed);
    }

    /**
     * Acutaliza una raza existente en el sistema.
     *
     * @param breedId ID de la raza a modificar.
     * @param dto Objeto DTO con los datos para acutalizar la raza existente.
     * @return El DTO con la información de la raza actualizada.
     * @throws BreedNotFoundException Si no se encuentra la raza a modificar.
     * @throws SpeciesNotFoundException Si no se encuentra la especie correspondiente a la raza.
     */

    public BreedResponseDTO updateBreed(Long breedId, BreedRequestDTO dto) {
        Breed breed = breedRepository.findById(breedId).orElseThrow(() -> new BreedNotFoundException(breedId));
        Species species = speciesRepository.findById(dto.getSpeciesId()).orElseThrow(() -> new SpeciesNotFoundException(dto.getSpeciesId()));

        breedMapper.updateFromDto(dto, breed);
        breed.setSpecies(species);
        breedRepository.save(breed);

        return breedMapper.toDto(breed);
    }

    /**
     * Devuelve una lista con todas las razas cargadas.
     *
     * @return Lista con los DTOs que contienen la información de cada raza.
     */

    public List<BreedResponseDTO> getAllBreeds() {
        List<Breed> breeds = breedRepository.findAll();

        return breeds.stream()
                .map(breed -> breedMapper.toDto(breed))
                .collect(Collectors.toList());
    }
}
