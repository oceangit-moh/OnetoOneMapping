package com.oceantech.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oceantech.mapping.model.Technician;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long>{

}
