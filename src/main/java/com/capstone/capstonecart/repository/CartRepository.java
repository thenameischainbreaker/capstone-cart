package com.capstone.capstonecart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstone.capstonecart.entity.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>
{
@Query("SELECT c.userId FROM cart c WHERE c.cartId = :cartId")
Integer findUserIdByCartId(@Param("cartId") int cartId);

@Query("SELECT c.productId FROM cart c WHERE c.cartId = :cartId")
Integer findProductIdByCartId(@Param("cartId") int cartId);

List<Cart> findByUserId(int userId);




}
