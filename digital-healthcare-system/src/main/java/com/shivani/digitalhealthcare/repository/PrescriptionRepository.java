package com.shivani.digitalhealthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shivani.digitalhealthcare.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {

}