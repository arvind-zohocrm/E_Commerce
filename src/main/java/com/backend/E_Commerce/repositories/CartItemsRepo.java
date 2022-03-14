package com.backend.E_Commerce.repositories;

import com.backend.E_Commerce.entities.CartItems;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemsRepo extends JpaRepository<CartItems, Integer>{
    List<CartItems> findByCartItemsId(Integer cartItemsId);
    List<CartItems> findByUserId(Integer userId);        
}
