package ch.zli.m223.ksh21a.mw.springintro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "AppUser")
public class AppUserImpl implements AppUser {

    @Id
    @GeneratedValue()
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    private String passwordHash;


    public AppUserImpl(String email, String password) {
        this.email = email;
        setPassword(password);
    }

    protected AppUserImpl() {} // For JPA only

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    private void setPassword(String password) {
        // TODO should hash
        passwordHash = password;
    }
    
}
