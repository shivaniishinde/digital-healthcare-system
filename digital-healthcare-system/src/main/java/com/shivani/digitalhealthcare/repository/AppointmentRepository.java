package com.shivani.digitalhealthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivani.digitalhealthcare.entity.Appointment;
import com.shivani.digitalhealthcare.entity.Doctor;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	boolean existsByDoctorAndAppointmentDateAndAppointmentTime(Doctor doctor, String appointmentDate,
			String appointmentTime);
}