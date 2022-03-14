package com.backend.E_Commerce.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CartItems {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    public Integer cartItemsId;

    // FK
    @Column(name="userId")
    private Integer userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Products product;

    private Integer quantity;
    private Float itemValue;

    public CartItems(){}

    public CartItems(Integer userId, Products product, Integer quantity, Float itemValue){
        this.userId = userId;
        this.product = product;
        this.quantity = quantity;        
        this.itemValue = itemValue;
    }

    public Integer getCartItemsId() {
        return cartItemsId;
    }
    public Integer getUserId() {
        return userId;
    }
    public Products getProduct() {
        return product;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public Float getItemValue() {
        return itemValue;
    }


    public void setCartItemsId(Integer cartItemsId) {
        this.cartItemsId = cartItemsId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public void setProductId(Products product) {
        this.product = product;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public void setItemValue(Float item_value) {
        this.itemValue = item_value;
    }
}
