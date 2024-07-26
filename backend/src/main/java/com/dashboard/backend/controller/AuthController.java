package com.dashboard.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dashboard.backend.dto.CredentialsDto;
import com.dashboard.backend.dto.LoginResponseDto;
import com.dashboard.backend.dto.UserDto;
import com.dashboard.backend.entity.Admin;
import com.dashboard.backend.entity.Owner;
import com.dashboard.backend.entity.Tenant;
import com.dashboard.backend.repository.AdminRepository;
import com.dashboard.backend.repository.OwnerRepository;
import com.dashboard.backend.repository.TenantRepository;
import com.dashboard.backend.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private OwnerRepository ownerRepository;
    
    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private AdminRepository adminRepository;
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/search/{emailId}")
    public Integer searchUserPresentInData(@PathVariable String emailId){
        Tenant tenant = tenantRepository.findByEmailId(emailId);

        if(tenant == null){
            return 1;
        }
        else if(tenant.getPassword() == null){
            return 2;
        }
        else {
            return 3;
        }
    }

    @GetMapping("/login/{email}/{password}")
    public LoginResponseDto login(@PathVariable String email, @PathVariable String password) {
        UserDto userDto = userService.login(new CredentialsDto(email, password));
        Owner owner = ownerRepository.findByEmailId(email);
        Tenant tenant = tenantRepository.findByEmailId(email);
        Admin admin = adminRepository.findByEmailId(email);
        Integer num;
        
        if (admin != null && admin.getPassword().equals(password)) {
            num = 1;
        }
        else if (owner != null && owner.getPassword().equals(password)) {
            num = 2;
        
        } else if (tenant != null && tenant.getPassword().equals(password)) {
            num = 3;

        } else {
            num = 4;
        }

        return new LoginResponseDto(num, userDto.getEmailId(), userDto.getToken());
    }

    @GetMapping("/signup/{email}/{finalPass}")
    public boolean signup(@PathVariable String email, @PathVariable String finalPass) {
        System.out.println(email);
        try {
            Tenant tenant = tenantRepository.findByEmailId(email);
            if (tenant != null) {
                tenant.setPassword(finalPass);
                tenantRepository.save(tenant);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
