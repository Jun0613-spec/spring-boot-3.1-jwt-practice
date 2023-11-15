package com.security.dto.request.auth;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignInRequestDto {
    
    @NotNull
    private String email;
    @NotNull
    private String password;
    
}
