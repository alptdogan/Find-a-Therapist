package com.alpdogan.PsychologyClinic.configuration;

import com.alpdogan.PsychologyClinic.entity.Therapist;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class MyTherapistPrincipal implements UserDetails {

    private Therapist therapist;

    public MyTherapistPrincipal(Therapist therapist) {
        this.therapist = therapist;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("THERAPIST"));
    }

    @Override
    public String getPassword() {
        return therapist.getPassword();
    }

    @Override
    public String getUsername() {
        return therapist.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
