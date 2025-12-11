package com.example.pet_history.service;

import com.example.pet_history.dto.species.SpeciesRequestDTO;
import com.example.pet_history.dto.species.SpeciesResponseDTO;
import com.example.pet_history.entity.Species;
import com.example.pet_history.exception.SpeciesNotFoundException;
import com.example.pet_history.mapper.SpeciesMapper;
import com.example.pet_history.repository.SpeciesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio para gestionar las distintas especies de las mascotas.
 * Provee métodos para crear, actualizar y obtener un listado con todas las especies cargadas.
 * Solo accesible para los administradores de la aplicación.
 */

@Service
@RequiredArgsConstructor
public class SpeciesService {
    private final SpeciesRepository speciesRepository;
    private final SpeciesMapper speciesMapper;

    /**
     * Registra una nueva especie en el sistema.
     *
     * @param dto Objeto DTO con los datos para crear una nueva especie.
     * @param image Archivo imagen para la nueva especie.
     * @return El DTO con la información de la especie recién creada.
     */

    public SpeciesResponseDTO newSpecies(SpeciesRequestDTO dto, MultipartFile image) {
        Species species = speciesMapper.toEntity(dto);

        // Lógica para subir la imágen a la nube
        //species.setImageUrl();

        speciesRepository.save(species);
        return speciesMapper.toDto(species);
    }

    /**
     * Acutaliza una especie existente en el sistema.
     *
     * @param speciesId ID de la especie a modificar.
     * @param dto Objeto DTO con los datos para acutalizar la especie existente.
     * @param image Archivo imagen para la especie.
     * @return El DTO con la información de la especie actualizada.
     * @throws SpeciesNotFoundException Si no se encuentra dicha especie en el sistema.
     */

    public SpeciesResponseDTO updateSpecies(Long speciesId, SpeciesRequestDTO dto, MultipartFile image) {
        Species species = speciesRepository.findById(speciesId).orElseThrow(()-> new SpeciesNotFoundException(speciesId));

        speciesMapper.updateFromDto(dto, species);

        // Lógica para subir la imágen a la nube
        //species.setImageUrl();

        speciesRepository.save(species);
        return speciesMapper.toDto(species);
    }

    /**
     * Devuelve una lista con todas las especies cargadas.
     *
     * @return Lista con los DTOs que contienen la información de cada especie.
     */

    public List<SpeciesResponseDTO> getAllSpecies(){
        List<Species> species = speciesRepository.findAll();

        return species.stream()
                .map(speciesMapper::toDto)
                .collect(Collectors.toList());
    }

}
