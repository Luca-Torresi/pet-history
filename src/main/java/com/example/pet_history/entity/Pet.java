package com.example.pet_history.entity;

import com.example.pet_history.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table
public class Pet {

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long ownerId;
    private String name;
    private LocalDate birthDate;
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne @JoinColumn(name = "breedId")
    private Breed breed;

    @OneToMany(mappedBy = "pet")
    @ToString.Exclude
    private List<MedicalRecord> medicalRecords;

}
