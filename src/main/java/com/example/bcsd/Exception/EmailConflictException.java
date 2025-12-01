package com.example.bcsd.Exception;

public class EmailConflictException extends RuntimeException {
    public EmailConflictException(String email) {
        super("이미 존재하는 이메일입니다: " + email);
    }
}
