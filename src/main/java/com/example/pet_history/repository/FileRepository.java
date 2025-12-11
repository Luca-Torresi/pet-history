package com.example.pet_history.repository;

import com.example.pet_history.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File,Long> {
}
