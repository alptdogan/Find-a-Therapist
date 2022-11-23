package com.alpdogan.PsychologyClinic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import javax.validation.constraints.NotNull;

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

}
