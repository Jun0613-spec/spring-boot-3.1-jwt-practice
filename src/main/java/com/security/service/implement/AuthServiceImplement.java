package com.security.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.dto.request.auth.SignInRequestDto;
import com.security.dto.request.auth.SignUpRequestDto;
import com.security.dto.response.ResponseDto;
import com.security.dto.response.auth.SignInResponseDto;
import com.security.dto.response.auth.SignUpResponseDto;
import com.security.entity.User;
import com.security.provider.JwtProvider;
import com.security.repository.UserRepository;
import com.security.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService{

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {

        try {

           String email = dto.getEmail();
           boolean existedEmail = userRepository.existsByEmail(email);
           if(existedEmail) return SignUpResponseDto.duplicateEmail();

           String nickname= dto.getNickname();
           boolean existedNickname = userRepository.existsByNickname(nickname);
           if(existedNickname) return SignUpResponseDto.duplicateNickname();
           
           String password = dto.getPassword();
           String encodedPassword = passwordEncoder.encode(password);
           dto.setPassword(encodedPassword);
           
           User userEntity = new User(dto);
           userRepository.save(userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.success();
    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        
        String token = null;

        try { 

            String email = dto.getEmail();
            User userEntity = userRepository.findByEmail(email);
            if(userEntity == null) return SignInResponseDto.signInFail();
            
            String password = dto.getPassword();
            String encodedPassword = userEntity.getPassword();
            boolean isMatched = passwordEncoder.matches(password, encodedPassword);
            if(!isMatched) return SignInResponseDto.signInFail();

            token = jwtProvider.create(email);
            
        } catch (Exception exception) {
           exception.printStackTrace();
           return ResponseDto.databaseError();
        }

        return SignInResponseDto.success(token);
        
    }
    
}
