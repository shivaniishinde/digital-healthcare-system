package com.shivani.digitalhealthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivani.digitalhealthcare.entity.Prescription;
import com.shivani.digitalhealthcare.service.PrescriptionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

	@Autowired
	private PrescriptionService prescriptionService;

	@PostMapping
	public Prescription savePrescription(@Valid @RequestBody Prescription prescription) {
		return prescriptionService.savePrescription(prescription);
	}

	@GetMapping
	public List<Prescription> getAllPrescriptions() {
		return prescriptionService.getAllPrescriptions();
	}

	@GetMapping("/{id}")
	public Prescription getPrescriptionById(@PathVariable Long id) {
		return prescriptionService.getPrescriptionById(id);
	}
	
	@PutMapping("/{id}")
	public Prescription updatePrescription(@PathVariable Long id,
	                                       @RequestBody Prescription prescription) {

	    return prescriptionService.updatePrescription(id, prescription);
	}

	@DeleteMapping("/{id}")
	public String deletePrescription(@PathVariable Long id) {
		prescriptionService.deletePrescription(id);
		return "Prescription deleted successfully";
	}
}