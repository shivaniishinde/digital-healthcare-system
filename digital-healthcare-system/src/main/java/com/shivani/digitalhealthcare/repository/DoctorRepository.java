
package com.shivani.digitalhealthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shivani.digitalhealthcare.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
