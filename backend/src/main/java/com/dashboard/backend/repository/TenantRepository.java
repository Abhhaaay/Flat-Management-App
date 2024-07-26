package com.dashboard.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dashboard.backend.entity.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {
    public boolean existsByEmailId(String emailId);
    public Tenant findByEmailId(String emailId);
}
