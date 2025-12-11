package com.example.pet_history.controller;

import com.example.pet_history.dto.breed.BreedRequestDTO;
import com.example.pet_history.dto.breed.BreedResponseDTO;
import com.example.pet_history.service.BreedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/breed")
public class BreedController {
    private final BreedService breedService;


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BreedResponseDTO> newBreed(@RequestBody BreedRequestDTO dto) {
        return ResponseEntity.ok(breedService.newBreed(dto));
    }

    @PutMapping("/{breedId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BreedResponseDTO> updateBreed(
            @PathVariable Long breedId,
            @RequestBody BreedRequestDTO dto) {
        return ResponseEntity.ok(breedService.updateBreed(breedId, dto));
    }

    @GetMapping
    public ResponseEntity<List<BreedResponseDTO>> getAllBreeds() {
        return ResponseEntity.ok(breedService.getAllBreeds());
    }

}
