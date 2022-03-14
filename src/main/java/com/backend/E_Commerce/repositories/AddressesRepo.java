package com.backend.E_Commerce.repositories;

import com.backend.E_Commerce.entities.Addresses;
import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepo extends JpaRepository<Addresses, Integer>{
    List<Addresses> findBySellerId(Integer sellerId);
    List<Addresses> findByUserId(Integer userId);
}
