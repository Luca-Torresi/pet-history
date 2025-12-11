package com.example.pet_history.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table
public class Medication {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brandName;
    private String description;
    private String activeIngredient;
    private String manufacturer;

}
