package com.backend.E_Commerce.repositories;

import com.backend.E_Commerce.entities.Orders;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Integer>{
    List<Orders> findByOrdersetId(Integer ordersetId);
}
