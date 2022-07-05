package com.example.serverspring.security.jwt;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;

@Data
public class JwtPatient implements UserDetails {

    private final Integer id;
    private final String login;
    private final String secondName;
    private final String firstName;
    private final String middleName;
    private final String password;
    private final String email;
    private final LocalDate birthdate;
    private final String sex;

    public JwtPatient(Integer id, String login, String secondName, String firstName, String middleName, String password, String email, LocalDate birthdate, String sex) {
        this.id = id;
        this.login = login;
        this.secondName = secondName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.sex = sex;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
