package com.example.bcsd.dto;

import com.example.bcsd.model.Member;

public class MemberCreateRequest {

    private String name;
    private String email;
    private String password;

    public MemberCreateRequest() {}

    public MemberCreateRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Member toEntity() {
        return new Member(name, email, password);
    }
}
