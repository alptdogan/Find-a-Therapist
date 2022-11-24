package com.alpdogan.PsychologyClinic.configuration;

import com.alpdogan.PsychologyClinic.entity.Clients;
import com.alpdogan.PsychologyClinic.entity.Therapist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    @Bean
    protected InMemoryUserDetailsManager configureAuthentication() {

        List<UserDetails> userDetails = new ArrayList<>();

        List<GrantedAuthority> clientRoles = new ArrayList<>();
        clientRoles.add(new SimpleGrantedAuthority("CLIENT"));

        List<GrantedAuthority> therapistRoles = new ArrayList<>();
        therapistRoles.add(new SimpleGrantedAuthority("THERAPIST"));

        //the userName and the password are the same here
        userDetails.add((UserDetails) new Clients("gokaycimen",
                "$2a$10$Q9smVn4D6iICd/KiP9ZnnuHoD.mw8QM2iPUW4nMOzQTkGpdWhfDYm",
                clientRoles));

        //the userName and the password are the same here also
        userDetails.add((UserDetails) new Therapist("alptugdogan",
                "$2a$10$qEvT82u7FBV1V72jd.OSAOEoZA5xiaWrm0vSeINGsvfQH58mzuBSW",
                therapistRoles));

        return new InMemoryUserDetailsManager(userDetails);

    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {

        return new BCryptPasswordEncoder(10);

    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/employee/fetchall").hasAuthority("THERAPIST")
                .antMatchers("/employee/fetch/*").hasAnyAuthority("CLIENT", "THERAPIST")
                .antMatchers("/employee/*").permitAll()
                .and().formLogin();

        return http.build();

    }

}
