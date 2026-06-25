package com.shivani.digitalhealthcare.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String specialization;

    private String qualification;

    private String experience;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<Appointment> appointments;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSpecialization() {
		return specialization;
	}


	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<Appointment> getAppointments() {
		return appointments;
	}


	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
    
    
}