package com.example.pet_history.controller;

import com.example.pet_history.dto.vaccine.VaccineRequestDTO;
import com.example.pet_history.dto.vaccine.VaccineResponseDTO;
import com.example.pet_history.service.VaccineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vaccine")
public class VaccineController {
    private final VaccineService vaccineService;

    @PostMapping
    public ResponseEntity<VaccineResponseDTO> createVaccine(@Valid @RequestBody VaccineRequestDTO dto){
        return ResponseEntity.ok().body(vaccineService.createVaccine(dto));
    }

    @PutMapping("/{vaccineId}")
    public ResponseEntity<VaccineResponseDTO> updateVaccine(
            @PathVariable Long vaccineId,
            @Valid @RequestBody VaccineRequestDTO dto){
        return ResponseEntity.ok().body(vaccineService.updateVaccine(vaccineId, dto));
    }

    @GetMapping
    public ResponseEntity<List<VaccineResponseDTO>> getAllVaccines(){
        return ResponseEntity.ok().body(vaccineService.getAllVaccines());
    }

}









