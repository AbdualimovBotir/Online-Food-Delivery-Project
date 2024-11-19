package com.botir.repository;

import com.botir.model.Cart;
import com.botir.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
    public Cart findByCustomerId(Long userId);
}
