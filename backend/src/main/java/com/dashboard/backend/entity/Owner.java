package com.dashboard.backend.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "owners")
public class Owner {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "flat_no")
    private int flatNo;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "email_id")
    private String emailId;
    
    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "password")
    private String password;
    
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tenant> tenants;

    @Column(name = "maintenance")
    private int maintenance;

    @Column(name = "maintenance_status")
    private String status;
    
    public Owner() {
    }
    
    public Owner(int flatNo, String name, String emailId, String contactNo, String password, List<Tenant> tenants, int maintenance, String status) {
        this.flatNo = flatNo;
        this.name = name;
        this.emailId = emailId;
        this.contactNo = contactNo;
        this.password = password;
        this.tenants = tenants;
        this.maintenance = maintenance;
        this.status = status;
    }
    
    // Getters and setters
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlatNo() {
        return flatNo;
    }

    public void setFlatNo(int flatNo) {
        this.flatNo = flatNo;
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

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Tenant> getTenants() {
        return tenants;
    }

    public void setTenants(List<Tenant> tenants) {
        this.tenants = tenants;
    }

    public int getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
