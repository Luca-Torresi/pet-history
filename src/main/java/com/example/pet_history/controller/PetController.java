package com.example.pet_history.controller;

import com.example.pet_history.dto.pet.PetRequestDTO;
import com.example.pet_history.dto.pet.PetResponseDTO;
import com.example.pet_history.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pet")
public class PetController {
    private final PetService petService;

    @PostMapping
    public ResponseEntity<PetResponseDTO> createPetProfile(
            @RequestHeader(value = "X-Owner-ID") Long ownerId,
            @Valid @RequestBody PetRequestDTO dto) {
        return ResponseEntity.ok().body(petService.createPetProfile(ownerId, dto));
    }

    @GetMapping("/{petId}")
    public ResponseEntity<PetResponseDTO> getPetById(@PathVariable Long petId) {
        return ResponseEntity.ok().body(petService.getPetById(petId));
    }

    @GetMapping("/owner")
    public ResponseEntity<List<PetResponseDTO>> getPetsByOwnerId(
            @RequestHeader(value = "X-Owner-ID") Long ownerId) {
        return ResponseEntity.ok().body(petService.getPetsByOwnerId(ownerId));
    }

    @PutMapping("/{petId}")
    public ResponseEntity<PetResponseDTO> updatePetProfile(@PathVariable Long petId, @Valid @RequestBody PetRequestDTO dto) {
        return ResponseEntity.ok().body(petService.updatePetProfile(petId, dto));
    }

}
