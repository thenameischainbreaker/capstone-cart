package com.capstone.capstonecart.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capstone.capstonecart.entity.Cart;
import com.capstone.capstonecart.repository.CartRepository;


@Service
public class CartServiceImpl implements CartService{
@Autowired
CartRepository jpa;
@Value("${gateway-host}")
private String gatewayHost;	
	
	@Override
	public List<Cart> getAllByUser(int id) {
		// TODO Auto-generated method stub
	return jpa.findByUserId(id);
	}

	
	//check if userId in newCart is userId in token header
	@Override
	public boolean addCart(Cart newCart) {
		// TODO Auto-generated method stub
		//get cartId
		newCart.setCartId(0);  
		//get productId
		int productId = newCart.getProductId();
		//get quantity
		int quantity = newCart.getQuantity();
		//find stock quantity from productId in Stock service

		  RestTemplate restTemplate = new RestTemplate(); 
		  String url = "http://" + gatewayHost + "/stock/get/" + productId;
		  System.out.println("gatewayHost: " +gatewayHost);
		  ResponseEntity<Integer> response = restTemplate.getForEntity(url, Integer.class); 
		  int stock_amount = response.getBody();
		  
		  if(quantity<=stock_amount) {
			  jpa.save(newCart);
			  return true;
		  }
	 
	   return false;
	    
	}

	@Override
	public boolean updateCartQuantity(int cartId, int quantity) {
		// TODO Auto-generated method stub
		//get product from cartId
		int productId = this.findProductIdByCartId(cartId);
		//find stock quantity from productId in Stock service
	//	System.out.println("product id:" +productId);
		
		  
		

		  RestTemplate restTemplate = new RestTemplate(); 
		  String url = "http://" + gatewayHost + "/stock/get/" + productId;
		  System.out.println("gatewayHost: " +gatewayHost);
		  ResponseEntity<Integer> response = restTemplate.getForEntity(url, Integer.class); 
		  int stock_amount = response.getBody();
		 
		
		if (quantity <= stock_amount) {
			Optional<Cart> optionalCart = jpa.findById(cartId);
			if (optionalCart.isPresent()) {
				Cart existingCart = optionalCart.get();
				existingCart.setQuantity(quantity);
				jpa.save(existingCart);
				return true;
			}
			return false;
		}
		else
			return false;
	}

	@Override
	public void deleteCartById(int cartId) {
		jpa.deleteById(cartId);
		
	}

	@Override
	public int findUserIdbyCartId(int cartId) {
		// TODO Auto-generated method stub
		return jpa.findUserIdByCartId(cartId);
	}

	@Override
	public int findProductIdByCartId(int cartId) {
		// TODO Auto-generated method stub
			return jpa.findProductIdByCartId(cartId);
	}



}
