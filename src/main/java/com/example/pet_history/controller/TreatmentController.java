package com.example.pet_history.controller;

import com.example.pet_history.dto.administration.AdministrationRequestDTO;
import com.example.pet_history.dto.treatment.TreatmentRequestDTO;
import com.example.pet_history.dto.treatment.TreatmentResponseDTO;
import com.example.pet_history.service.TreatmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/treatment")
public class TreatmentController {
    private final TreatmentService treatmentService;

    @PostMapping("/{medicalRecordId}")
    public ResponseEntity<TreatmentResponseDTO> registerNewTreatment(@PathVariable Long medicalRecordId, @Valid @RequestBody TreatmentRequestDTO dto) {
        return ResponseEntity.ok(treatmentService.registerNewTreatment(medicalRecordId, dto));
    }

    @PutMapping("/{treatmentId}")
    public ResponseEntity<TreatmentResponseDTO> updateTreatment(
            @PathVariable Long treatmentId,
            @Valid @RequestBody TreatmentRequestDTO dto){
        return ResponseEntity.ok(treatmentService.updateTreatment(treatmentId, dto));
    }

    @GetMapping("/{petId}")
    public ResponseEntity<List<TreatmentResponseDTO>> getAllTreatmentsByPetId(@PathVariable Long petId) {
        return  ResponseEntity.ok(treatmentService.getAllTreatmentsByPetId(petId));
    }

    @PostMapping("/newAdministration/{petId}")
    public ResponseEntity<TreatmentResponseDTO> addNewAdministration(
            @PathVariable Long treatmentId,
            @Valid @RequestBody AdministrationRequestDTO dto) {
        return  ResponseEntity.ok(treatmentService.addNewAdministration(treatmentId, dto));
    }

}
