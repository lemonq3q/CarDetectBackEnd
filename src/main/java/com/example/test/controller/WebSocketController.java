package com.example.test.controller;

import com.example.test.entity.User;
import com.example.test.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

    @Autowired
    private WebSocketService webSocketService;

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return webSocketService.login(user);
    }

    @GetMapping("/getTest")
    public String getTest(String username){
        return webSocketService.getTest(username);
    }
}
