package com.alpdogan.PsychologyClinic.configuration;

import com.alpdogan.PsychologyClinic.entity.Therapist;
import com.alpdogan.PsychologyClinic.repository.ClientsRepository;
import com.alpdogan.PsychologyClinic.repository.TherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    TherapistRepository therapistRepository;

  /*  @Autowired
    ClientsRepository clientsRepository;

   */

    @Override
    public UserDetails loadUserByUsername(String username) {
        Therapist therapist = therapistRepository.findByUsername(username);
        if (therapist == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyTherapistPrincipal(therapist);
    }

}
