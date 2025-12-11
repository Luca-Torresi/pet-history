package com.example.pet_history.controller;

import com.example.pet_history.dto.medication.MedicationRequestDTO;
import com.example.pet_history.dto.medication.MedicationResponseDTO;
import com.example.pet_history.service.MedicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class MedicationController {
    private final MedicationService medicationService;

    @PostMapping
    public ResponseEntity<MedicationResponseDTO> createMedication(@Valid @RequestBody MedicationRequestDTO dto) {
        return ResponseEntity.ok().body(medicationService.createMedication(dto));
    }

    @PutMapping("/{medicationId}")
    public ResponseEntity<MedicationResponseDTO> updateMedication(
            @PathVariable Long medicationId,
            @Valid @RequestBody MedicationRequestDTO dto){
        return ResponseEntity.ok().body(medicationService.updateMedication(medicationId, dto));
    }

    @GetMapping
    public ResponseEntity<List<MedicationResponseDTO>> getAllMedications(){
        return ResponseEntity.ok().body(medicationService.getAllMedications());
    }
}
