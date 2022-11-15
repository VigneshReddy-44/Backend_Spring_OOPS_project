package com.example.demo.repository;

import com.example.demo.model.Cart_items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<Cart_items,Integer> {
}
