package com.shivani.digitalhealthcare.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.shivani.digitalhealthcare.dto.RegisterRequest;
import com.shivani.digitalhealthcare.entity.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User register(@Valid @RequestBody RegisterRequest request) {

        return authService.register(request);

    }

}