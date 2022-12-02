package com.alpdogan.PsychologyClinic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "therapist")
public class Therapist {

    @Id
    @NotNull
    private int id;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private long phoneNumber;
    @NotNull
    private String address;
    @NotNull
    private String email;

    @NotBlank
    private String username;
    @NotBlank
    private String password;

    private List<GrantedAuthority> therapistRoles;

    public Therapist(String username, String password, List<GrantedAuthority> therapistRoles) {
        this.username = username;
        this.password = password;
        this.therapistRoles = therapistRoles;
    }
}
