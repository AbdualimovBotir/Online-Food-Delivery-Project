package com.botir.service;

import com.botir.dto.RestaurantDto;
import com.botir.model.Restaurant;
import com.botir.model.User;
import com.botir.request.CreateRestaurantRequest;

import java.util.List;

public interface RestaurantService {
    public Restaurant createRestaurant(CreateRestaurantRequest req, User user);
    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant)throws Exception;
    public void deleteRestaurant(Long restaurantId)throws Exception;
    public List<Restaurant> getAllRestaurant();
    public List<Restaurant>searchRestaurant(String keyword);
    public Restaurant findRestaurantById(Long id)throws Exception;
    public Restaurant getRestaurantByUserId(Long userId)throws Exception;
    public RestaurantDto addToFavourites(Long restaurantId,User user)throws Exception;
    public Restaurant updateRestaurantStatus(Long id)throws Exception;
}
