package com.example.pet_history.repository;

import com.example.pet_history.entity.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepository extends JpaRepository<Species,Long> {
}
