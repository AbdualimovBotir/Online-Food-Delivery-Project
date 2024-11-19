package com.botir.repository;

import com.botir.model.Orderitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<Orderitem,Long> {
}
