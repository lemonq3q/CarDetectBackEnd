package com.example.test.service.impl;

import com.example.test.entity.User;
import com.example.test.service.WebSocketService;
import com.example.test.WebSocket.TestEndpoint;
import org.springframework.stereotype.Service;

import javax.websocket.Session;

@Service
public class WebSocketimpl implements WebSocketService {
    @Override
    public String login(User user) {
        if(user != null && "123".equals(user.getPassword())) {
            return "succeed";
        }else{
            return "false";
        }
    }

    @Override
    public String getTest(String username) {
        try {
            Session session = TestEndpoint.onlineUsers.get(username);
            session.getBasicRemote().sendText("hello");
        }catch (Exception e){

        }
        return "已经发送数据";
    }
}
