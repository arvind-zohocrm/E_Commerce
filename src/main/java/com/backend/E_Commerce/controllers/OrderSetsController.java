package com.backend.E_Commerce.controllers;

import com.backend.E_Commerce.repositories.OrderSetsRepo;
// import com.backend.E_Commerce.repositories.OrdersRepo;
import com.backend.E_Commerce.entities.Ordersets;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/ordersets")
public class OrderSetsController {
    @Autowired
    private OrderSetsRepo orderSetsRepo;

    @GetMapping
    List<Ordersets> getOrderSets(){
        return orderSetsRepo.findAll();
    }

    @GetMapping("/find")
    List<Ordersets> getOrderSetsByUserId(@RequestParam String user_id){
        System.out.println(user_id);
        return orderSetsRepo.findByUserId(Integer.valueOf(user_id));
    }

    @GetMapping("/{ordersets_id}")
    Ordersets getOrderSetsById(@PathVariable Integer ordersets_id){
        Optional<Ordersets> optionalOrdersets =  orderSetsRepo.findById(ordersets_id);
        if( optionalOrdersets.isPresent()){
            return optionalOrdersets.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested resource does not exists");
    }
    @PostMapping
    Ordersets createOrderSets(@RequestBody Ordersets orderSet){
        return orderSetsRepo.save(orderSet);
    }

    @PutMapping("/{orderset_id}")
    Ordersets updatOrderSets(@RequestBody Ordersets orderSet, @PathVariable Integer orderset_id){
        Optional<Ordersets> optionalOrderSet =  orderSetsRepo.findById(orderset_id);
        if(optionalOrderSet.isPresent()){
            orderSet.setOrdersetId(orderset_id);            
            return orderSetsRepo.save(orderSet);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Requested Resource not found");
    }

    @DeleteMapping("/{ordersets_id}")
    HttpStatus deleteOrdersetsById(@PathVariable Integer ordersets_id){
        Optional<Ordersets> optionalOrdersets = orderSetsRepo.findById(ordersets_id);
        if( optionalOrdersets.isPresent()){
            orderSetsRepo.deleteById(ordersets_id);
            return HttpStatus.OK;
        }
        else return HttpStatus.NOT_FOUND;
    }


}
