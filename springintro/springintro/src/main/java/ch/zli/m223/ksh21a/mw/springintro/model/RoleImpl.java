package ch.zli.m223.ksh21a.mw.springintro.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "Role")
public class RoleImpl implements Role {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(nullable = false, unique = true)
    private String role;

    public RoleImpl(String role) {
        this.role = role;
    }

    protected RoleImpl() {};

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getRole() {
        return role;
    }

    

}
