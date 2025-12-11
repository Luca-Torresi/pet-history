package com.example.pet_history.service;

import com.example.pet_history.dto.pet.PetRequestDTO;
import com.example.pet_history.dto.pet.PetResponseDTO;
import com.example.pet_history.entity.Breed;
import com.example.pet_history.entity.Pet;
import com.example.pet_history.exception.BreedNotFoundException;
import com.example.pet_history.exception.PetNotFoundException;
import com.example.pet_history.mapper.PetMapper;
import com.example.pet_history.repository.BreedRepository;
import com.example.pet_history.repository.PetRepository;
import com.example.pet_history.repository.SpeciesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio para gestionar la lógica de negocio de los perfiles de las mascotas.
 * Provee métodos para crear, actualizar y consultar información de las mascotas.
 */

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    private final BreedRepository breedRepository;
    private final PetMapper petMapper;
    private final SpeciesRepository speciesRepository;

/**
 * Registra nuevo perfil de mascota en el sistema.
 *
 * @param dto Objeto DTO con los datos para crear el nuevo perfil de mascota.
 * @return El DTO del perfil de la nueva mascota.
 * @throws BreedNotFoundException Si no se encuentra la raza seleccionada.
 */

    public PetResponseDTO createPetProfile(Long ownerId, PetRequestDTO dto) {
        Breed breed = breedRepository.findById(dto.getIdBreed()).orElseThrow(() -> new BreedNotFoundException(dto.getIdBreed()));

        Pet pet = petMapper.toEntity(dto);
        pet.setOwnerId(ownerId);
        pet.setBreed(breed);
        petRepository.save(pet);

        return petMapper.toDto(pet);
    }

    /**
     * Actualiza el perfil de una mascota existente en el sistema.
     *
     * @param petId ID de la mascota.
     * @param dto Objeto DTO con los datos para actualizar el perfil de la mascota.
     * @return El DTO del perfil actualizado de la mascota.
     * @throws PetNotFoundException Si no se encuentra la mascota en la base de datos.
     * @throws BreedNotFoundException Si no se encuentra la raza seleccionada.
     */

    public PetResponseDTO updatePetProfile(Long petId, PetRequestDTO dto) {
        Pet pet = petRepository.findById(petId).orElseThrow(() -> new PetNotFoundException(petId));
        Breed breed = breedRepository.findById(dto.getIdBreed()).orElseThrow(() -> new BreedNotFoundException(dto.getIdBreed()));

        petMapper.updateFromDto(dto, pet);
        pet.setBreed(breed);
        petRepository.save(pet);

        return petMapper.toDto(pet);
    }

    /**
     * Obtienen la información del perfil de una mascota.
     *
     * @param petId ID de la mascota.
     * @return El DTO del perfil de la mascota.
     * @throws PetNotFoundException Si no se encuentra la mascota en la base de datos.
     */

    public PetResponseDTO getPetById(Long petId) {
        Pet pet = petRepository.findById(petId).orElseThrow(() -> new PetNotFoundException(petId));
        return petMapper.toDto(pet);
    }

    /**
     * Obtinen la información de todas las mascotas de un mismo dueño.
     *
     * @param ownerId ID del dueño.
     * @return Una lista de DTOs, donde se encuentra toda la información de cada mascosta del dueño.
     */

    public List<PetResponseDTO> getPetsByOwnerId(Long ownerId) {
        List<Pet> pets = petRepository.findAllByOwnerId(ownerId);

        return pets.stream()
                .map(petMapper::toDto)
                .collect(Collectors.toList());
    }

}
