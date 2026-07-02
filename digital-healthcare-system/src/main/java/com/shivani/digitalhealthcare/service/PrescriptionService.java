package com.shivani.digitalhealthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivani.digitalhealthcare.entity.Prescription;
import com.shivani.digitalhealthcare.exception.PrescriptionNotFoundException;
import com.shivani.digitalhealthcare.repository.PrescriptionRepository;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public Prescription savePrescription(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public Prescription getPrescriptionById(Long id) {
    	return prescriptionRepository.findById(id)
    	        .orElseThrow(() -> new  PrescriptionNotFoundException("Prescription not found"));
    }
    
    public void deletePrescription(Long id) {
        prescriptionRepository.deleteById(id);
    }
}