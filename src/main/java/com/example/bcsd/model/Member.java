package com.example.bcsd.model;

import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    protected Member() {
    }

    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
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

    public void changeName(String name) {
        this.name = name;
    }

    public void changeEmail(String email) {
        this.email = email;
    }

    public void changePassword(String encodedPassword) {
        this.password = encodedPassword;
    }

    public void update(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
