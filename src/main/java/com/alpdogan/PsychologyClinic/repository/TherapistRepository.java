package com.alpdogan.PsychologyClinic.repository;

import com.alpdogan.PsychologyClinic.entity.Clients;
import com.alpdogan.PsychologyClinic.entity.Therapist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TherapistRepository extends MongoRepository<Therapist, Integer> {

    Therapist findBy_id(int _id);

    @Query("{'Clients.firstName':?0}")
    List<Clients> findByFirstName(String firstName);

}
