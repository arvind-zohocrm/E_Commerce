package com.backend.E_Commerce.controllers;

import com.backend.E_Commerce.repositories.CartItemsRepo;
import com.backend.E_Commerce.entities.CartItems;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/cartitems")
public class CartItemsController {
    @Autowired
    CartItemsRepo cartItemsRepo;

    @GetMapping
    List<CartItems> getCartItems(){
        return cartItemsRepo.findAll();
    }

    @GetMapping("/{user_id}")
    List<CartItems> getCartItemsByUserId(@PathVariable Integer user_id){
        return cartItemsRepo.findByUserId(user_id);
    }

    @PostMapping
    CartItems createCartItems(@RequestBody CartItems cartItem){
        return cartItemsRepo.save(cartItem);
    }

    @PutMapping("/{cart_id}")
    CartItems updateCartItems(@RequestBody CartItems cartItem, @PathVariable Integer cart_id){
        Optional<CartItems> optionalCartItems =  cartItemsRepo.findById(cart_id);
        if( optionalCartItems.isPresent()){
            cartItem.setCartItemsId(cart_id);
            return cartItemsRepo.save(cartItem);
        }
        throw new ResponseStatusException(HttpStatus.FOUND, "Requested resouce does not exists");
    }

    @DeleteMapping("/{cart_id}")
    HttpStatus deleteCartItems(@PathVariable Integer cart_id){
        Optional<CartItems> optionalCartItems =  cartItemsRepo.findById(cart_id);
        if( optionalCartItems.isPresent()){
            cartItemsRepo.deleteById(cart_id);
            return HttpStatus.OK;
        }
        throw new ResponseStatusException(HttpStatus.FOUND, "Requested resouce does not exists");
    }
}
