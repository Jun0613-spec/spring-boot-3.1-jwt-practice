package com.security.service;

import org.springframework.http.ResponseEntity;

import com.security.dto.response.user.GetSignInUserResponseDto;

public interface UserService {

    ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email);
    
}
