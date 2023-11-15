package com.security.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.security.dto.response.ResponseDto;
import com.security.dto.response.user.GetSignInUserResponseDto;
import com.security.entity.User;
import com.security.repository.UserRepository;
import com.security.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService{

    private final UserRepository userRepository;
    
    @Override
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String email) {

        User userEntity = null;
        
        try {
           

            userEntity = userRepository.findByEmail(email);
            if(userEntity == null)  return GetSignInUserResponseDto.notExistUser();
            
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();

        }

        return GetSignInUserResponseDto.success(userEntity);
    }


    
}
