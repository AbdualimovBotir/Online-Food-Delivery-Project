package com.botir.response;

import com.botir.model.USER_ROLE;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
    private String jwt;
    private String message;
    private USER_ROLE role;

}
