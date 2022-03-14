package com.backend.E_Commerce.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Addresses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer addressId;

    // FK    
    // private Integer owner_id;
    private String flat;
    private String street;
    private String city;
    private String state;
    private Integer pincode;    
    private Integer sellerId;
    private Integer userId;

    public Addresses(){}

    public Addresses(Integer sellerId, Integer userId, String flat, String street, String city, String state, Integer pincode){
        this.sellerId = sellerId;
        this.userId = userId;
        this.flat = flat;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;        
    }
    
    public Integer getAddressId() {
        return addressId;
    }
    public Integer getUserId() {
        return userId;
    }
    public Integer getSellerId() {
        return sellerId;
    }
    public String getflat() {
        return flat;
    }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }    
    public Integer getPincode() {
        return pincode;
    }    

    public void setAddressId(Integer addressId) {
        this.addressId =addressId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }
    public void setflat(String flat) {
        this.flat = flat;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setState(String state) {
        this.state = state;
    }
    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }    
    
}
