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

import com.shivani.digitalhealthcare.entity.Doctor;
import com.shivani.digitalhealthcare.service.DoctorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@GetMapping("/test")
	public String test() {
		return "Doctor API";
	}

	@PostMapping
	public Doctor saveDoctor(@Valid @RequestBody Doctor doctor) {
		return doctorService.saveDoctor(doctor);
	}

	@GetMapping
	public List<Doctor> getAllDoctors() {
		return doctorService.getAllDoctors();
	}

	@GetMapping("/{id}")
	public Doctor getDoctorById(@PathVariable Long id) {
		return doctorService.getDoctorById(id);
	}

	@PutMapping("/{id}")
	public Doctor updateDoctor(@PathVariable Long id,
	                           @RequestBody Doctor doctor) {

	    return doctorService.updateDoctor(id, doctor);
	}
	@DeleteMapping("/{id}")
	public String deleteDoctor(@PathVariable Long id) {
		doctorService.deleteDoctor(id);
		return "Doctor deleted successfully";
	}
}