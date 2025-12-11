package com.example.pet_history.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table
public class Administration {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dosage;
    private String duration;

    @ManyToOne @JoinColumn(name = "treatmentId")
    private Treatment treatment;

    @ManyToOne @JoinColumn(name = "medicationId")
    private Medication medication;
}
