package com.example.pet_history.repository;

import com.example.pet_history.entity.Breed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreedRepository extends JpaRepository<Breed,Long> {
}
