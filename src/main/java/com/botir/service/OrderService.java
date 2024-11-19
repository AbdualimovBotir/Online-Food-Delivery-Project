package com.botir.service;

import com.botir.model.Order;
import com.botir.model.User;
import com.botir.request.OrderRequest;

import java.util.List;

public interface OrderService {
    public Order createOrder(OrderRequest order, User user) throws Exception;
    public Order updateOrder(Long orderId,String orderStatus)throws Exception;
    public void cencelOrder(Long orderId)throws Exception;
    public List<Order>getUserOrder(Long userId)throws Exception;
    public List<Order>getRestaurantOrder(Long restaurantId,String orderStatus)throws Exception;
    public Order findOrderById(Long orderId)throws Exception;
}
