package com.dashboard.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.backend.entity.Owner;
import com.dashboard.backend.entity.Tenant;
import com.dashboard.backend.repository.OwnerRepository;
import com.dashboard.backend.repository.TenantRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private TenantRepository tenantRepository;
    
    @GetMapping("/")
    public List<Owner> getAllOwners(){
        List<Owner> owners = ownerRepository.findAll();
            owners.forEach(owner -> {
            owner.getTenants().size(); 
        });
        return owners;
    }

    @GetMapping("/search/{emailId}")
    public boolean searchOwner(@PathVariable String emailId) {
        return ownerRepository.existsByEmailId(emailId);
    }

    @GetMapping("/{emailId}")
    public Owner getTenantsByOwner(@PathVariable String emailId) {
        Owner owner = ownerRepository.findByEmailId(emailId);

        return owner;
    }

    @GetMapping("/remove-tenant/{emailId}")
    public String removeTenant(@PathVariable String emailId) {
        try {
            Tenant tenant = tenantRepository.findByEmailId(emailId);
            
            if (tenant != null) {
                tenantRepository.delete(tenant);
                return "Tenant removed successfully";
            } else {
                return "Tenant not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error removing tenant";
        }
    }
}
