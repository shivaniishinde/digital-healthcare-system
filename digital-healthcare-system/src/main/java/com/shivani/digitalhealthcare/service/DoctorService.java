package com.shivani.digitalhealthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivani.digitalhealthcare.entity.Doctor;
import com.shivani.digitalhealthcare.exception.DoctorNotFoundException;
import com.shivani.digitalhealthcare.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public List<Doctor> getAllDoctors() {
		return doctorRepository.findAll();
	}

	public Doctor getDoctorById(Long id) {
		return doctorRepository.findById(id).orElseThrow(() -> new DoctorNotFoundException("Doctor not found"));
	}

	public void deleteDoctor(Long id) {
		doctorRepository.deleteById(id);
	}
}