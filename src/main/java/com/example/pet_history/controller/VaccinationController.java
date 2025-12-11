package com.example.pet_history.controller;

import com.example.pet_history.dto.vaccination.VaccinationRequestDTO;
import com.example.pet_history.dto.vaccination.VaccinationResponseDTO;
import com.example.pet_history.service.VaccinationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vaccination")
public class VaccinationController {
    private final VaccinationService vaccinationService;

    @PostMapping("/{medicalRecordId}")
    public ResponseEntity<VaccinationResponseDTO> registerVaccination(
            @PathVariable Long medicalRecordId,
            @Valid @RequestBody VaccinationRequestDTO dto) {
        return ResponseEntity.ok(vaccinationService.registerVaccination(medicalRecordId, dto));
    }

    @PutMapping("/{vaccinationId}")
    public ResponseEntity<VaccinationResponseDTO> updateVaccination(
            @PathVariable Long vaccinationId,
            @Valid @RequestBody VaccinationRequestDTO dto) {
        return ResponseEntity.ok(vaccinationService.updateVaccination(vaccinationId, dto));
    }

    @GetMapping("/{petId}")
    public ResponseEntity<List<VaccinationResponseDTO>> getVaccination(@PathVariable Long petId) {
        return  ResponseEntity.ok(vaccinationService.getVaccinations(petId));
    }

    @GetMapping("/due/{petId}")
    public ResponseEntity<List<VaccinationResponseDTO>> getDueVaccination(@PathVariable Long petId) {
        return ResponseEntity.ok(vaccinationService.getDueVaccinations(petId));
    }

}
