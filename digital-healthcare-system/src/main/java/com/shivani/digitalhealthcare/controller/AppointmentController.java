package com.shivani.digitalhealthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shivani.digitalhealthcare.entity.Appointment;
import com.shivani.digitalhealthcare.entity.AppointmentStatus;
import com.shivani.digitalhealthcare.service.AppointmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public Appointment saveAppointment(@Valid @RequestBody Appointment appointment) {
        return appointmentService.saveAppointment(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "Appointment deleted successfully";
    }
    
    @PutMapping("/{id}/status")
    public Appointment updateAppointmentStatus(
            @PathVariable Long id,
            @RequestParam AppointmentStatus status) {

        return appointmentService.updateAppointmentStatus(id, status);
    }
}
