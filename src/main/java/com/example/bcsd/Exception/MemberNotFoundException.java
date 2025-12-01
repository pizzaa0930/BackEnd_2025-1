package com.example.bcsd.Exception;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(Long id) {
        super("해당 사용자를 찾을 수 없습니다.");
    }
}
