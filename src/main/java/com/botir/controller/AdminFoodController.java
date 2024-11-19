package com.botir.controller;

import com.botir.model.Food;
import com.botir.model.Restaurant;
import com.botir.model.User;
import com.botir.request.CreateFoodRequest;
import com.botir.response.MessageResponce;
import com.botir.service.FoodService;
import com.botir.service.RestaurantService;
import com.botir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    UserService userService;
    @Autowired
    private RestaurantService restaurantService;
    @PostMapping()
    private ResponseEntity<Food>createFood(@RequestBody CreateFoodRequest req,
                                           @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        Restaurant restaurant=restaurantService.findRestaurantById(req.getRestaurantId());
        Food food=foodService.createFood(req,req.getCategory(),restaurant);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<MessageResponce>deleteFood(@PathVariable Long id,
                                                      @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        foodService.deleteFood(id);
        MessageResponce res=new MessageResponce();
        res.setMessage("food deleted successfully");
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Food>updateFoodAvavilityStatus(@PathVariable Long id,
                                                      @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        Food food= foodService.updateAvailibilityStatus(id);
        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

}
