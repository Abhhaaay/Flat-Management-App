package com.dashboard.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.backend.entity.Tenant;
import com.dashboard.backend.repository.TenantRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tenant")
public class TenantController {

    @Autowired
    private TenantRepository tenantRepository;
    
    @GetMapping("/")
    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }

    @GetMapping("/search/{emailId}")
    public boolean searchTenant(@PathVariable String emailId) {
        return tenantRepository.existsByEmailId(emailId);
    }

    @GetMapping("/login/{emailId}/{password}")
    public Integer getMethodName(@PathVariable String emailId, @PathVariable String password) {
        Tenant tenant = tenantRepository.findByEmailId(emailId);
        if (tenant == null) {
            return 1;
        }
        else if(!(tenant.getPassword().equals(password))){
            return 2;
        }
        else {
            return 3;
        }
    }
    

    @PostMapping("/signup/{emailId}/{password}")
    public boolean setPassword(@PathVariable String emailId, @PathVariable String password) {
        Tenant tenant = tenantRepository.findByEmailId(emailId);
        if (tenant == null) {
            return false;
        }

        tenant.setPassword(password);
        tenantRepository.save(tenant);

        return true;
    }
    
}
