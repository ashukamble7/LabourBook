package com.example.labour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.labour.model.Labour;

@Repository
public interface LabourRepository extends JpaRepository<Labour, Long>{

}
