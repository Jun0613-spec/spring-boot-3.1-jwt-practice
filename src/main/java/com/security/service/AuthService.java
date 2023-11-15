package com.security.service;

import org.springframework.http.ResponseEntity;

import com.security.dto.request.auth.SignInRequestDto;
import com.security.dto.request.auth.SignUpRequestDto;
import com.security.dto.response.auth.SignUpResponseDto;
import com.security.dto.response.auth.SignInResponseDto;

public interface AuthService {

    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
