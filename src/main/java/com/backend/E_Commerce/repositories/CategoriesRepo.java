package com.backend.E_Commerce.repositories;

import com.backend.E_Commerce.entities.Categories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepo extends JpaRepository<Categories, Integer>{
    
}
