package com.security.dto.response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.security.common.ResponseCode;
import com.security.common.ResponseMessage;
import com.security.dto.response.ResponseDto;
import com.security.entity.User;

import lombok.Getter;

@Getter
public class GetSignInUserResponseDto extends ResponseDto{
    
    private String email;
    private String userName;
    private String profileImage;

    private GetSignInUserResponseDto(User userEntity) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        
        this.email = userEntity.getEmail();
        this.userName = userEntity.getUserName();
        this.profileImage = userEntity.getProfileImage();
    }

    public static ResponseEntity<GetSignInUserResponseDto> success(User userEntity) {

        GetSignInUserResponseDto result = new GetSignInUserResponseDto(userEntity);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }
    
}
