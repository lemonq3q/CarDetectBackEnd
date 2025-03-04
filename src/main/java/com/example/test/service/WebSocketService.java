package com.example.test.service;

import com.example.test.entity.User;
import org.springframework.web.bind.annotation.RequestBody;

public interface WebSocketService {

    public String login(@RequestBody User user);

    public String getTest(String username);
}
