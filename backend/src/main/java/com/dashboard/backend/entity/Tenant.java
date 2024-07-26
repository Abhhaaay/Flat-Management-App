package com.dashboard.backend.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "tenants")
public class Tenant implements UserDetails{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @JsonBackReference
    private Owner owner;
    
    @Column(name = "name", length = 20)
    private String name;
    
    @Column(name = "email_id", length = 20)
    private String emailId;
    
    @Column(name = "password", length = 20)
    private String password;
    
    @Column(name = "contact_no", length = 15)
    private String contactNo;
    
    @Column(name = "flat_no")
    private int flatNo;

     @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
    
    public Tenant() {
    }
    
    public Tenant(Owner owner, String name, String emailId, String password, String contactNo, int flatNo) {
        this.owner = owner;
        this.name = name;
        this.emailId = emailId;
        this.password = password;
        this.contactNo = contactNo;
        this.flatNo = flatNo;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(int flatNo) {
        this.flatNo = flatNo;
    }

    @Override
    public String getUsername() {
        return emailId;
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
