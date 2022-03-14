package com.backend.E_Commerce.repositories;

import com.backend.E_Commerce.entities.Ordersets;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSetsRepo extends JpaRepository<Ordersets, Integer>{
    List<Ordersets> findByUserId(Integer user_id);    
}
