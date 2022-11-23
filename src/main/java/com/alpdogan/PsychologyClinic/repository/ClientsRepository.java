package com.alpdogan.PsychologyClinic.repository;

import com.alpdogan.PsychologyClinic.entity.Clients;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends MongoRepository<Clients, String> {

    Clients findBy_id(int _id);

}
