package com.capstone.capstonecart.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.capstonecart.entity.Cart;
import com.capstone.capstonecart.service.CartServiceImpl;




@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = {"https://domainofchain.s3.us-east-2.amazonaws.com","http://localhost:4200/", "http://localhost:4200/","https://capstone-angular-jj.s3.us-east-2.amazonaws.com"})
public class CartController {
	@Autowired
	CartServiceImpl service;

@GetMapping("/getAllByUser/{id}")
public List<Cart> getAllByUser(@PathVariable int id){
	return service.getAllByUser(id);
}

@PostMapping("/addCart")
public String addCart(@RequestBody Cart cart) {
	try {
		service.addCart(cart);
		return "\"Cart added successfully\"";
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "\"Error no cart added.\"";
	}
	
}

@PutMapping("/updateQuantity")
//check if cartId matches userId
public String updateCart(@RequestParam(name = "cartId")  int cartId, @RequestParam(name = "quantity") int quantity) {
	try {
		return service.updateCartQuantity(cartId, quantity) ? "\"Quantity updated successfully\"" : "\"Quanity not updated\"";
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "\"Error in updating cart\"";
	}
}
	
@DeleteMapping("/deleteCart")
public String deleteCart(@RequestParam(name = "cartId")  int cartId) {
	try {
		service.deleteCartById(cartId);
		return "\"Cart deleted successfully.\"";
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return "\"Error in deleting cart.\"";
	}
	
}


@GetMapping("/getUserIdByCartId")
public Integer getUserIdByCartId(@RequestParam(name = "cartId")  int cartId) {
	return service.findUserIdbyCartId(cartId);
}

@GetMapping("")
public String test() {
	return "test success";
}

	
	
}
