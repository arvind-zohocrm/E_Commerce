package com.backend.E_Commerce.controllers;

import com.backend.E_Commerce.entities.Addresses;
import com.backend.E_Commerce.entities.CartItems;
import com.backend.E_Commerce.entities.Ordersets;
import com.backend.E_Commerce.entities.Users;
import com.backend.E_Commerce.repositories.UsersRepo;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
public class UsersController {
    // Need to create Error handlers

    // Service and DTO
    // 
    @Autowired
    private UsersRepo usersRepo;

    @GetMapping()
    List<Users> getUsers(){
        return usersRepo.findAll();
    }

    @GetMapping("/{user_id}")
    Users getUserById(@PathVariable Integer user_id){
        return usersRepo.findById(user_id).get();
    }

    @GetMapping("/{user_id}/cartitems")
    List<CartItems> getCartItemsByUserId(@PathVariable Integer user_id){
        return usersRepo.findById(user_id).get().getCartItems();
    }

    @GetMapping("/{user_id}/addresses")
    List<Addresses> getAddressesByUserId(@PathVariable Integer user_id){
        return usersRepo.findById(user_id).get().getAddresses();
    }

    @GetMapping("/{user_id}/ordersets")
    List<Ordersets> getOrdersetsByUserId(@PathVariable Integer user_id){
        return usersRepo.findById(user_id).get().getOrdersets();
    }

    @PostMapping()
    Users createUser(@RequestBody Users user){
        System.out.println("Users post method..");
        return usersRepo.save(user);        
    }

    @PostMapping("/{user_id}/authenticate")
    String checkPassword(@PathVariable Integer user_id, @RequestBody String pass){        
        Optional<Users> optionalUsers = usersRepo.findById(user_id);
        if( optionalUsers.isPresent() ){
            Users user = usersRepo.findById(user_id).get();

            String enteredPass = Users.encryptPass(pass, user.getSalt());  
            System.out.println("Inside authentication entered : "+pass + "  encrypted : "+enteredPass);
            System.out.println("stored salt : " + user.getSalt() + " stored pass : "+ user.getPassword());
            
            if(user.getPassword().equals(enteredPass)) return "success";
            else return "failure";

        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The requested user_id does not exists");
        }        
    }

    @PutMapping("/{user_id}")
    Users updateUser(@PathVariable Integer user_id, @RequestBody Users users){
        Optional<Users> optionalUser = usersRepo.findById(user_id);
        if( optionalUser.isPresent()){
            users.setId(optionalUser.get().getId());
            return usersRepo.save(users);
        }
        return null;
    }

    @PutMapping("/{user_id}/addresses")
    Users updateAddressesByUserId(@PathVariable Integer user_id, @RequestBody List<Addresses> addresses){
        Optional<Users> optionalUser = usersRepo.findById(user_id);
        if( optionalUser.isPresent() ){
            Users user = optionalUser.get();
            user.setAddresses(addresses);
            return usersRepo.save(user);
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The requested user_id does not exists");
    }

    @PutMapping("/{user_id}/ordersets")
    Users updateOrdersetsByUserId(@PathVariable Integer user_id, @RequestBody List<Ordersets> ordersets){
        Optional<Users> optionalUser = usersRepo.findById(user_id);
        if( optionalUser.isPresent() ){
            Users user = optionalUser.get();
            user.setOrdersets(ordersets);
            return usersRepo.save(user);
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The requested user_id does not exists");
    }

    @PutMapping("/{user_id}/cartitems")
    Users updateCartItemsByUserId(@PathVariable Integer user_id, @RequestBody List<CartItems> cartItems){
        Optional<Users> optionalUser = usersRepo.findById(user_id);
        if( optionalUser.isPresent() ){
            Users user = optionalUser.get();
            user.setCartItems(cartItems);
            return usersRepo.save(user);
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The requested user_id does not exists");
    }
    
    @DeleteMapping("/{user_id}")
    HttpStatus deleteUsersById(@PathVariable Integer user_id){
        Optional<Users> optionalProduct = usersRepo.findById(user_id);
        if( optionalProduct.isPresent()){
            usersRepo.deleteById(user_id);
            return HttpStatus.OK;
        }
        else return HttpStatus.NOT_FOUND;
    }
}
