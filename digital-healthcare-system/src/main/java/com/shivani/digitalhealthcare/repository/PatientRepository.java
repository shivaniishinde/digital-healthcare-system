package com.shivani.digitalhealthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivani.digitalhealthcare.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
