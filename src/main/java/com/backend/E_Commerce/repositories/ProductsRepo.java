package com.backend.E_Commerce.repositories;

import com.backend.E_Commerce.entities.Products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Integer>{
    
}
