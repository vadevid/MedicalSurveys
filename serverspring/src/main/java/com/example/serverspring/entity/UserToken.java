package com.example.serverspring.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserToken {
    private String userLogin;
    private String userToken;

    public UserToken(String userLogin, String userToken){
        this.userLogin = userLogin;
        this.userToken = userToken;
    }
}
