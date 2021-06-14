package com.example.hellospring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;
    private String password;
    private int role; // 1.user, 2.admin

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private Set<Credential> credentials = new HashSet<>();

    public void setCredentials(Set<Credential> credentials) {
        this.credentials = credentials;

        for(Credential c : credentials) {
            c.setUser(this);
        }
    }

    public User(String userName, String password, int role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
}
