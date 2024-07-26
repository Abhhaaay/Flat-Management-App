package com.dashboard.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.backend.entity.Owner;
import com.dashboard.backend.repository.OwnerRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerRepository ownerRepository;
    
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

    @GetMapping("/login/{emailId}/{password}")
    public Integer loginOwner(@PathVariable String emailId, @PathVariable String password) {
        Owner owner = ownerRepository.findByEmailId(emailId);
        if (owner == null) {
            return 1;
        }
        else if(!(owner.getPassword().equals(password))){
            return 2;
        }
        else {
            return 3;
        }
    }
}
