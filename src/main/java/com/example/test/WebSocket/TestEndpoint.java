package com.example.test.WebSocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/test/{userid}")
@Component
public class TestEndpoint {
    public static final Map<String, Session> onlineUsers = new ConcurrentHashMap<>();

    private String userid;
    @OnOpen
    public void onOpen(Session session, @PathParam("userid")String userid) {
        this.userid = userid;
        onlineUsers.put(userid,session);
    }

    @OnMessage
    public void onMessage(String message){

    }

    @OnClose
    public void onClose(Session session){

    }

}
