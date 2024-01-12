package com.oceantech.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oceantech.mapping.model.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long>{

}
