package com.example.serverspring.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserToken {
    private String userLogin;
    private String userToken;

    public UserToken(String userLogin, String userToken){
        this.userLogin = userLogin;
        this.userToken = userToken;
    }
}
