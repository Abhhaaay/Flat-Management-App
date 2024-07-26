package com.dashboard.backend.service;

import com.dashboard.backend.config.UserAuthProvider;
import com.dashboard.backend.dto.CredentialsDto;
import com.dashboard.backend.dto.SignUpDto;
import com.dashboard.backend.dto.UserDto;
import com.dashboard.backend.entity.Admin;
import com.dashboard.backend.entity.Owner;
import com.dashboard.backend.entity.Tenant;
import com.dashboard.backend.exception.AppException;
import com.dashboard.backend.mapper.UserMapper;
import com.dashboard.backend.repository.AdminRepository;
import com.dashboard.backend.repository.OwnerRepository;
import com.dashboard.backend.repository.TenantRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@RequiredArgsConstructor
@Service
public class UserService {
    
    @Autowired
    private final AdminRepository adminRepository;
    @Autowired
    private final OwnerRepository ownerRepository;
    @Autowired
    private final TenantRepository tenantRepository;
    @Autowired
    private final UserMapper userMapper;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final UserAuthProvider userAuthProvider;

    public UserDto findByLogin(String emailId) {
        Admin admin = adminRepository.findByEmailId(emailId);
        if (admin != null) {
            return userMapper.toUserDto(admin);
        }

        Owner owner = ownerRepository.findByEmailId(emailId);
        if (owner != null) {
            return userMapper.toUserDto(owner);
        }

        Tenant tenant = tenantRepository.findByEmailId(emailId);
        if (tenant != null) {
            return userMapper.toUserDto(tenant);
        }

        throw new AppException("Unknown user", HttpStatus.NOT_FOUND);
    }

    public UserDto login(CredentialsDto credentialsDto) {
        String emailId = credentialsDto.getEmailId();
        String password = CharBuffer.wrap(credentialsDto.getPassword()).toString();

        Admin admin = adminRepository.findByEmailId(emailId);
        if (admin != null && passwordEncoder.matches(password, admin.getPassword())) {
            String token = userAuthProvider.createToken(admin.getEmailId());
            return UserDto.builder()
                    .login(admin.getEmailId())
                    .token(token)
                    .build();
        }

        Owner owner = ownerRepository.findByEmailId(emailId);
        if (owner != null && passwordEncoder.matches(password, owner.getPassword())) {
            String token = userAuthProvider.createToken(owner.getEmailId());
            return UserDto.builder()
                    .login(owner.getEmailId())
                    .token(token)
                    .build();
        }

        Tenant tenant = tenantRepository.findByEmailId(emailId);
        if (tenant != null && passwordEncoder.matches(password, tenant.getPassword())) {
            String token = userAuthProvider.createToken(tenant.getEmailId());
            return UserDto.builder()
                    .login(tenant.getEmailId())
                    .token(token)
                    .build();
        }

        throw new AppException("Invalid credentials", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto signUpDto) {
        String emailId = signUpDto.getEmailId();

        if (adminRepository.findByEmailId(emailId) != null ||
            ownerRepository.findByEmailId(emailId) != null ||
            tenantRepository.findByEmailId(emailId) != null) {
            throw new AppException("Email already exists", HttpStatus.BAD_REQUEST);
        }

        Tenant tenant = userMapper.signUpToTenant(signUpDto);
        tenant.setPassword(passwordEncoder.encode(CharBuffer.wrap(signUpDto.getPassword()).toString()));
        Tenant savedTenant = tenantRepository.save(tenant);

        return userMapper.toUserDto(savedTenant);
    }
}