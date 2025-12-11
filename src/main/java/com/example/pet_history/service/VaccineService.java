package com.example.pet_history.service;

import com.example.pet_history.dto.vaccine.VaccineRequestDTO;
import com.example.pet_history.dto.vaccine.VaccineResponseDTO;
import com.example.pet_history.entity.Vaccine;
import com.example.pet_history.exception.VaccineNotFoundException;
import com.example.pet_history.mapper.VaccineMapper;
import com.example.pet_history.repository.VaccineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio para gestionar las vacunas.
 * Provee métodos para crear, actualizar y obtener un listado con todas las vacunas cargadas.
 * Solo accesible para los administradores de la aplicación.
 */

@Service
@RequiredArgsConstructor
public class VaccineService {
    private final VaccineRepository vaccineRepository;
    private final VaccineMapper vaccineMapper;

    /**
     * Registra una nueva vacuna en el sistema.
     *
     * @param dto Objeto DTO con los datos para cargar la nueva vacuna.
     * @return El DTO con la información de la vacuna recién creada.
     */

    public VaccineResponseDTO createVaccine(VaccineRequestDTO dto) {
        Vaccine vaccine = vaccineMapper.toEntity(dto);
        vaccineRepository.save(vaccine);

        return vaccineMapper.toDTO(vaccine);
    }

    /**
     * Acutaliza una vacuna existente en el sistema.
     *
     * @param vaccineId ID de la vacuna a modificar.
     * @param dto Objeto DTO con los datos para acutalizar la vacuna existente.
     * @return El DTO con la información de la vacuna actualizada.
     * @throws VaccineNotFoundException Si no se encuentra dicha vacuna en el sistema.
     */

    public VaccineResponseDTO updateVaccine(Long vaccineId, VaccineRequestDTO dto) {
        Vaccine vaccine = vaccineRepository.findById(vaccineId).orElseThrow(() -> new VaccineNotFoundException(vaccineId));

        vaccineMapper.updateFromDTO(dto, vaccine);
        vaccineRepository.save(vaccine);

        return vaccineMapper.toDTO(vaccine);
    }

    /**
     * Devuelve una lista con todas las vacunas.
     *
     * @return Lista con los DTOs que contienen la información de cada vacuna.
     */

    public List<VaccineResponseDTO> getAllVaccines() {
        List<Vaccine> vaccines = vaccineRepository.findAll();

        return vaccines.stream()
                .map(vaccine -> vaccineMapper.toDTO(vaccine))
                .collect(Collectors.toList());
    }
}
