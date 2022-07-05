package com.example.serverspring.repository;

import com.example.serverspring.entity.UserToken;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TokenRepository {
    private List<UserToken> usersTokenList;

    public TokenRepository(){
        usersTokenList = new ArrayList<>();
    }

    public List<UserToken> getUsersTokenList() {
        return usersTokenList;
    }
}