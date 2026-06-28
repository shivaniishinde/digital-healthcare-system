package com.shivani.digitalhealthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivani.digitalhealthcare.entity.Appointment;
import com.shivani.digitalhealthcare.entity.AppointmentStatus;
import com.shivani.digitalhealthcare.entity.Doctor;
import com.shivani.digitalhealthcare.entity.Patient;
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
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
    
    public Appointment updateAppointmentStatus(Long id, AppointmentStatus status) {

        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setStatus(status);

        return appointmentRepository.save(appointment);
    }
}