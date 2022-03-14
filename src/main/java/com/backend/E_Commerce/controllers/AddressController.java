package com.backend.E_Commerce.controllers;

import java.util.List;
import java.util.Optional;

import com.backend.E_Commerce.entities.Addresses;
import com.backend.E_Commerce.repositories.AddressesRepo;

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
@RequestMapping("/addresses")
public class AddressController {
    @Autowired
    private AddressesRepo addressesRepo;

    @GetMapping
    List<Addresses> getAddresses(){
        return addressesRepo.findAll();
    }

    @GetMapping("/{address_id}")
    Addresses getAddressByAddressId(@PathVariable Integer address_id){
        Optional<Addresses> optionalAddress =  addressesRepo.findById(address_id);
        if(optionalAddress.isPresent()) return optionalAddress.get();
        else{            
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The requested address_id does not exist");
        }
    }
    @PostMapping
    Addresses createAddresses(@RequestBody Addresses addresses){
        return addressesRepo.save(addresses);
    }

    @PutMapping("/{address_id}")
    Addresses updateAddresses(@RequestBody Addresses addresses, @PathVariable Integer address_id){
        Optional<Addresses> optionalgAddresses = addressesRepo.findById(address_id);
        if( optionalgAddresses.isPresent()){
            addresses.setAddressId( optionalgAddresses.get().getAddressId() );
            return addressesRepo.save(addresses);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The requested address_id does not exists");
        }
    }

    @DeleteMapping("/{address_id}")
    HttpStatus deleteAddressById(@PathVariable Integer address_id){
        Optional<Addresses> optionalAddress = addressesRepo.findById(address_id);
        if( optionalAddress.isPresent()){
            addressesRepo.deleteById(address_id);
            return HttpStatus.OK;
        }
        else return HttpStatus.NOT_FOUND;
    }
}

