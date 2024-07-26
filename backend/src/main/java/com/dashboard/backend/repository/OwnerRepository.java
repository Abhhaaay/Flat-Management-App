package com.dashboard.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dashboard.backend.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    public boolean existsByEmailId(String emailId);
    public Owner findByEmailId(String emailId);
}