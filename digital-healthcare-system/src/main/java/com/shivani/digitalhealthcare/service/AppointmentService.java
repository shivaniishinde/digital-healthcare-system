package com.shivani.digitalhealthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivani.digitalhealthcare.entity.Appointment;
import com.shivani.digitalhealthcare.entity.AppointmentStatus;
import com.shivani.digitalhealthcare.entity.Doctor;
import com.shivani.digitalhealthcare.entity.Patient;
import com.shivani.digitalhealthcare.exception.AppointmentNotFoundException;
import com.shivani.digitalhealthcare.exception.DoctorNotFoundException;
import com.shivani.digitalhealthcare.exception.PatientNotFoundException;
import com.shivani.digitalhealthcare.repository.AppointmentRepository;
import com.shivani.digitalhealthcare.repository.DoctorRepository;
import com.shivani.digitalhealthcare.repository.PatientRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private DoctorRepository doctorRepository;

	@Autowired
	private PatientRepository patientRepository;

	public Appointment saveAppointment(Appointment appointment) {

		Long doctorId = appointment.getDoctor().getId();
		Long patientId = appointment.getPatient().getId();

		Doctor doctor = doctorRepository.findById(doctorId)
				.orElseThrow(() -> new DoctorNotFoundException("Doctor not found"));

		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found"));

		// Duplicate Appointment Validation
		if (appointmentRepository.existsByDoctorAndAppointmentDateAndAppointmentTime(doctor,
				appointment.getAppointmentDate(), appointment.getAppointmentTime())) {

			throw new RuntimeException("Doctor is already booked for this time slot.");
		}

		appointment.setDoctor(doctor);
		appointment.setPatient(patient);

		return appointmentRepository.save(appointment);
	}

	public List<Appointment> getAllAppointments() {
		return appointmentRepository.findAll();
	}

	public Appointment getAppointmentById(Long id) {
		return appointmentRepository.findById(id)
				.orElseThrow(() -> new AppointmentNotFoundException("Appointment not found"));

	}

	public void deleteAppointment(Long id) {
		appointmentRepository.deleteById(id);
	}

	public Appointment updateAppointment(Long id, Appointment appointment) {

	    Appointment existingAppointment = appointmentRepository.findById(id)
	            .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found"));

	    existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
	    existingAppointment.setAppointmentTime(appointment.getAppointmentTime());
	    existingAppointment.setStatus(appointment.getStatus());

	    
	    return appointmentRepository.save(existingAppointment);
	}
}