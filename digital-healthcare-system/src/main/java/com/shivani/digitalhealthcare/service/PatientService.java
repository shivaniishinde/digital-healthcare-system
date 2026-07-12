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

	public Patient updatePatient(Long id, Patient patient) {

	    Patient existingPatient = patientRepository.findById(id)
	            .orElseThrow(() -> new PatientNotFoundException("Patient not found"));

	    existingPatient.setAge(patient.getAge());
	    existingPatient.setGender(patient.getGender());
	    existingPatient.setBloodGroup(patient.getBloodGroup());

	    return patientRepository.save(existingPatient);
	}
	public void deletePatient(Long id) {
		patientRepository.deleteById(id);
	}
}
