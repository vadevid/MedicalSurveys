package com.example.serverspring.exception;

public class TokenException extends Exception {
    public TokenException() {
        super("Токен не активен");
    }
}
