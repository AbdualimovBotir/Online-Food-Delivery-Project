package com.botir.controller;

import com.botir.dto.RestaurantDto;
import com.botir.model.Restaurant;
import com.botir.model.User;
import com.botir.service.RestaurantService;
import com.botir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    // Foydalanuvchini JWT token orqali topuvchi yordamchi metod
    private User getUserFromJwt(String jwt) throws Exception {
        return userService.findUserByJwtToken(jwt);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurant(
            @RequestHeader("Authorization") String jwt,
            @RequestParam String keyword
    ) throws Exception {
        // Foydalanuvchini JWT token orqali olish
        User user = getUserFromJwt(jwt);

        // Restoranlarni qidirish xizmati orqali topish
        List<Restaurant> restaurants = restaurantService.searchRestaurant(keyword);

        // Topilgan restoranlarni qaytarish
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurant(
            @RequestHeader("Authorization") String jwt
    ) throws Exception {
        // Foydalanuvchini JWT token orqali olish
        User user = getUserFromJwt(jwt);

        // Barcha restoranlarni olish
        List<Restaurant> restaurants = restaurantService.getAllRestaurant();

        // Topilgan restoranlarni qaytarish
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findRestaurantById(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception {
        // Foydalanuvchini JWT token orqali olish
        User user = getUserFromJwt(jwt);

        // Restoranni ID orqali topish
        Restaurant restaurant = restaurantService.findRestaurantById(id);

        // Agar restoran mavjud bo'lsa, qaytarish
        if (restaurant != null) {
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        } else {
            // Agar restoran topilmasa, NOT_FOUND qaytarish
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/favourites")
    public ResponseEntity<RestaurantDto> addToFavourites(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception {
        // Foydalanuvchini JWT orqali olish
        User user = getUserFromJwt(jwt);

        // Restoranni sevimlilarga qo'shish
        RestaurantDto restaurantDto = restaurantService.addToFavourites(id, user);

        // Javobni qaytarish
        return new ResponseEntity<>(restaurantDto, HttpStatus.OK);
    }
}
