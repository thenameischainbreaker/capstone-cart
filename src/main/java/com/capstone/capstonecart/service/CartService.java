package com.capstone.capstonecart.service;

import java.util.List;

import com.capstone.capstonecart.entity.Cart;



public interface CartService {

	public List<Cart> getAllByUser(int id);
	
	public boolean addCart(Cart newCart);
	
	public boolean updateCartQuantity(int cartId, int quantity);
	
	public void deleteCartById(int cartId);
	
	public int findUserIdbyCartId(int cartId);
	
	public int findProductIdByCartId(int cartId);
	

	
}
