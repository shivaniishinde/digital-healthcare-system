package com.shivani.digitalhealthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivani.digitalhealthcare.entity.Patient;
import com.shivani.digitalhealthcare.exception.PatientNotFoundException;
import com.shivani.digitalhealthcare.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;

	public Patient savePatient(Patient patient) {
		return patientRepository.save(patient);
	}

	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}

	public Patient getPatientById(Long id) {
		return patientRepository.findById(id).orElseThrow(() -> new PatientNotFoundException("Patient not found"));
	}

	public void deletePatient(Long id) {
		patientRepository.deleteById(id);
	}
}
