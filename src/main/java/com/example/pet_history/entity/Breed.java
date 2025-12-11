package com.example.pet_history.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table
public class Breed {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne @JoinColumn(name = "speciesId")
    @JsonBackReference @ToString.Exclude
    private Species species;
}
