package com.oceantech.mapping.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.oceantech.mapping.exceptions.ResourceNotFoundException;
import com.oceantech.mapping.model.Assignment;
import com.oceantech.mapping.model.Technician;
import com.oceantech.mapping.repository.AssignmentRepository;
import com.oceantech.mapping.repository.TechnicianRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Technician Assignment One-to-One Mapping", description = "shows One-to-One Mapping")
public class TechnicianController {
	
	@Autowired
    private TechnicianRepository technicianRepository;
	
	@Autowired
    private AssignmentRepository assignmentRepository;
	
	@ApiOperation(value = "Returns APIs for Technician Assignment One-to-One Mapping")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 100, message = "100 is the message"),
                    @ApiResponse(code = 200, message = "Successful Hello World")
            }
    )

	/* Technician APIs */
	
	@GetMapping("/technicians")
    public List < Technician > getTechnicians() {
        return technicianRepository.findAll();
    }
	
	@GetMapping("/technicians/{id}")
    public ResponseEntity < Technician > getTechnicianById(
        @PathVariable(value = "id") Long technicianId) throws ResourceNotFoundException {
		Technician technician = technicianRepository.findById(technicianId)
            .orElseThrow(() -> new ResourceNotFoundException("Technician not found :: " + technicianId));
        return ResponseEntity.ok().body(technician);
    }
	
	@PostMapping("/technicians")
    public Technician createTechnician(@Valid @RequestBody Technician technician) {
        return technicianRepository.save(technician);
    }
	
	@DeleteMapping("/technicians/{id}")
    public Map < String, Boolean > deleteTechnician(
        @PathVariable(value = "id") Long technicianId) throws ResourceNotFoundException {
		Technician technician = technicianRepository.findById(technicianId)
            .orElseThrow(() -> new ResourceNotFoundException("Technician not found :: " + technicianId));

        technicianRepository.delete(technician);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	/* Assignment APIs */
	
	
	@GetMapping("/assignments")
    public List < Assignment > getAssignments() {
        return assignmentRepository.findAll();
    }
	
	@GetMapping("/assignments/{id}")
    public ResponseEntity < Assignment > getAssignmentById(
        @PathVariable(value = "id") Long assignmentId) throws ResourceNotFoundException {
		Assignment assignment = assignmentRepository.findById(assignmentId)
            .orElseThrow(() -> new ResourceNotFoundException("Assignment not found :: " + assignmentId));
        return ResponseEntity.ok().body(assignment);
    }
	
	@PostMapping("/assignments")
    public Assignment createUser(@Valid @RequestBody Assignment assignment) {
        return assignmentRepository.save(assignment);
    }
	
	@DeleteMapping("/assignments/{id}")
    public Map < String, Boolean > deleteAssignment(
        @PathVariable(value = "id") Long assignmentId) throws ResourceNotFoundException {
		Assignment assignment = assignmentRepository.findById(assignmentId)
            .orElseThrow(() -> new ResourceNotFoundException("Technician not found :: " + assignmentId));

		assignmentRepository.delete(assignment);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
