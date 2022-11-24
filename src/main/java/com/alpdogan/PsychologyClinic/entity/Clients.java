package com.alpdogan.PsychologyClinic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Clients {

    @NotNull
    public int _id;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
    private List<GrantedAuthority> clientRoles;

    public Clients(String userName, String password, List<GrantedAuthority> clientRoles) {
        this.userName = userName;
        this.password = password;
        this.clientRoles = clientRoles;
    }
}
