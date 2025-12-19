package com.example.demo;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@EqualsAndHashCode(of = "username")

@Entity
public class MyUser{
    @Id
    private String username;
    private String password;
    private String authorities;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAuthorities() {
        return authorities;
    }
    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
    public MyUser(String username, String password, String authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }
    @Override
    public String toString() {
        return "MyUser [username=" + username + ", password=" + password + ", authorities=" + authorities + "]";
    }

    

    
}