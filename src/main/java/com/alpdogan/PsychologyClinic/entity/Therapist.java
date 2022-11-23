package com.alpdogan.PsychologyClinic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "therapist")
public class Therapist {

    @Id
    @NotNull
    private int _id;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    private List<Clients> clients;

}
