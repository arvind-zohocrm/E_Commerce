package com.backend.E_Commerce.repositories;

import com.backend.E_Commerce.entities.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer>{
    
}
