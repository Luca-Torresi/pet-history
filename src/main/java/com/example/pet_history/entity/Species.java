package com.example.pet_history.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity @Table
public class Species {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String imageUrl;

    @OneToMany(mappedBy = "species")
    @JsonManagedReference
    private List<Breed> breeds;
}
