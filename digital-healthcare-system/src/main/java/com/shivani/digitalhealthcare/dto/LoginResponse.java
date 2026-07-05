package com.shivani.digitalhealthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {

    private String token;

	public LoginResponse(String token) {
		super();
		this.token = token;
	}
    
}