package com.shivani.digitalhealthcare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shivani.digitalhealthcare.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByEmail(String email);

	Optional<User> findByEmail(String email);

}