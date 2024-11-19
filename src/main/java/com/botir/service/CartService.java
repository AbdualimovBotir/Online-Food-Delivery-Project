package com.botir.service;

import com.botir.model.Cart;
import com.botir.model.CartItem;
import com.botir.request.AddCartItemRequest;

public interface CartService {
    public CartItem addItemToCard(AddCartItemRequest req, String jwt)throws Exception;
    public CartItem updateCardItemQuentity(Long cartItemId,int quentity)throws Exception;
    public Cart removeItemFromCart(Long cartItemId,String jwt)throws Exception;
    public Long calculateCartTotals(Cart cart)throws Exception;
    public Cart findCartById(Long id)throws Exception;
    public Cart findCartByUserId(Long userId)throws Exception;
    public Cart clearCart(Long userId)throws Exception;
}
