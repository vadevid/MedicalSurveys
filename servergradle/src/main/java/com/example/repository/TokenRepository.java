package com.example.repository;

import com.example.entity.UserToken;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class TokenRepository {
    private List<UserToken> usersTokenList;

    public TokenRepository(){
        usersTokenList = new ArrayList<>();
    }

    public List<UserToken> getUsersTokenList() {
        return usersTokenList;
    }
}