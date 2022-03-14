package com.backend.E_Commerce.controllers;

import com.backend.E_Commerce.repositories.OrdersRepo;
import com.backend.E_Commerce.entities.Orders;

// import java.security.cert.PKIXRevocationChecker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersRepo ordersRepo;

    @GetMapping
    List<Orders> getOrders(){
        return ordersRepo.findAll();
    }

    @GetMapping("/{orders_id}")
    Orders getOrdersById(@PathVariable Integer orders_id){
        Optional<Orders> optionalOrders = ordersRepo.findById(orders_id);
        if( optionalOrders.isPresent()){
            return optionalOrders.get();
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested resource not found");
    }

    @PostMapping
    Orders createOrders(@RequestBody Orders order){
        return ordersRepo.save(order);
    }

    @PutMapping("/{orders_id}")
    Orders updateOrders(@RequestBody Orders orders, @PathVariable Integer orders_id){
        Optional<Orders> optionalOrders = ordersRepo.findById(orders_id);
        if( optionalOrders.isPresent()){
            orders.setOrderId(orders_id);
            return ordersRepo.save(orders);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested resource does not exists");
    }

    @DeleteMapping("/{orders_id}")
    HttpStatus deleteOrders(@PathVariable Integer orders_id){
        Optional<Orders> optionalOrders = ordersRepo.findById(orders_id);
        if( optionalOrders.isPresent()){
            ordersRepo.deleteById(orders_id);
            return HttpStatus.OK;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested resource does not exists");
    }
}
