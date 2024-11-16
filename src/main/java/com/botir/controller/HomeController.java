package com.botir.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    public ResponseEntity<String>HomeController(){
        return new ResponseEntity<>("Welcome to food delivry project", HttpStatus.OK);
    }
}
