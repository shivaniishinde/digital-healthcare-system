package com.shivani.digitalhealthcare.auth;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.shivani.digitalhealthcare.dto.LoginRequest;
import com.shivani.digitalhealthcare.dto.LoginResponse;
import com.shivani.digitalhealthcare.dto.RegisterRequest;
import com.shivani.digitalhealthcare.entity.User;
import com.shivani.digitalhealthcare.repository.UserRepository;
import com.shivani.digitalhealthcare.security.CustomUserDetails;
import com.shivani.digitalhealthcare.security.JwtService;

@Service
public class AuthService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService,
			AuthenticationManager authenticationManager) {

		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtService = jwtService;
		this.authenticationManager = authenticationManager;
	}

	public String register(RegisterRequest request) {

		if (userRepository.findByEmail(request.getEmail()).isPresent()) {
		    throw new ResponseStatusException(
		            HttpStatus.CONFLICT,
		            "Email already exists"
		    );
		}

		User user = new User();

		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(request.getRole());

		userRepository.save(user);

		return "User Registered Successfully";
	}
	
//	public String register(RegisterRequest request) {
//
//		if (userRepository.findByEmail(request.getEmail()).isPresent()) {
//		    throw new ResponseStatusException(
//		            HttpStatus.CONFLICT,
//		            "Email already exists"
//		    );
//		}
//
//	    User user = new User();
//	    user.setName(request.getName());
//	    user.setEmail(request.getEmail());
//	    user.setPassword(passwordEncoder.encode(request.getPassword()));
//	    user.setRole(request.getRole());
//
//	    userRepository.save(user);
//
//	    return "User Registered Successfully";
//	}

	public LoginResponse login(LoginRequest request) {

		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new RuntimeException("User not found"));

		UserDetails userDetails = new CustomUserDetails(user);

		String token = jwtService.generateToken(userDetails);

		return new LoginResponse(token);
	}
}