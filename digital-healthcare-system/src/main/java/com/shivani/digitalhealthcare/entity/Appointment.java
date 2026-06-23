package com.shivani.digitalhealthcare.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String appointmentDate;

    private String appointmentTime;

   
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;
    
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    
    
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}