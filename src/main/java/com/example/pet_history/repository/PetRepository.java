package com.example.pet_history.repository;

import com.example.pet_history.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {
    List<Pet> findAllByOwnerId(Long ownerId);
}
