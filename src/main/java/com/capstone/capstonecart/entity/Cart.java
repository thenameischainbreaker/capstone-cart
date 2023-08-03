package com.capstone.capstonecart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "cart")
public class Cart {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int cartId;
@Column(name = "userId")
private int userId;
private int productId;
private int quantity;
public Cart() {
	
}

public Cart(int cartId, int userId, int productId, int quantity) {
	super();
	this.cartId = cartId;
	this.userId = userId;
	this.productId = productId;
	this.quantity = quantity;
}

public int getCartId() {
	return cartId;
}

public void setCartId(int cartId) {
	this.cartId = cartId;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

}

