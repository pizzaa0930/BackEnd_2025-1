package com.example.bcsd.dto;

public class MemberLoginRequest {

    private String email;
    private String password;

    public MemberLoginRequest() {}

    public MemberLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
