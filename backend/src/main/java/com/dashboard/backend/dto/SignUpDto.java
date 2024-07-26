package com.dashboard.backend.dto;

import lombok.Data;

@Data
public class SignUpDto {
    private String emailId;
    private String password;
    private String name;
    private String contactNo;
    private int flatNo; // relevant for Owner and Tenant
}