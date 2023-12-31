package com.security.controller;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.dto.request.auth.SignInRequestDto;
import com.security.dto.request.auth.SignUpRequestDto;
import com.security.dto.response.auth.SignUpResponseDto;
import com.security.dto.response.auth.SignInResponseDto;
import com.security.service.AuthService;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<? super SignUpResponseDto> signUp(
        @RequestBody @Valid SignUpRequestDto requestBody
    ) {
        ResponseEntity<? super SignUpResponseDto> response = authService.signUp(requestBody);
        return response;
    }
    
    @PostMapping("/sign-in")
    public ResponseEntity<? super SignInResponseDto> signIn (
       @RequestBody @Valid SignInRequestDto requestBody
    ) {
       ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
       return response;
    }
    
}
