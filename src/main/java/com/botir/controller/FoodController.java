package com.botir.controller;

import com.botir.model.Food;
import com.botir.model.Restaurant;
import com.botir.model.User;
import com.botir.request.CreateFoodRequest;
import com.botir.service.FoodService;
import com.botir.service.RestaurantService;
import com.botir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/food")
public class FoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    UserService userService;
    @Autowired
    private RestaurantService restaurantService;
    @GetMapping("/search")
    private ResponseEntity<List<Food>> searchFood(@RequestParam String name,
                                            @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        List<Food> food=foodService.searchFood(name);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @GetMapping("/restaurant/{restaurantId}")
    private ResponseEntity<List<Food>> getRestaurantFood(@RequestParam boolean vegetarian,
                                                         @RequestParam boolean seasonal,
                                                         @RequestParam boolean nonveg,
                                                         @RequestParam(required = false)String food_category,
                                                         @PathVariable Long restaurantId,
                                                         @RequestHeader("Authorization") String jwt
                                                        ) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        List<Food> food=foodService.getRestaurantsFood(restaurantId,vegetarian,nonveg,seasonal,food_category);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

}
