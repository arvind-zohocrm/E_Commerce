package com.backend.E_Commerce.repositories;

import com.backend.E_Commerce.entities.Sellers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellersRepo extends JpaRepository<Sellers, Integer>{
    
}
