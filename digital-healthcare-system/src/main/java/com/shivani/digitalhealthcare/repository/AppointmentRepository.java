package com.shivani.digitalhealthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivani.digitalhealthcare.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}