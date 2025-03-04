package com.example.test.WebSocket;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//用于声明一个WebSocket端点。
// value属性指定了WebSocket的URL路径，其中{userid}是一个路径参数，表示每个连接的用户ID。
@ServerEndpoint(value = "/login/{userid}")

@Component
public class LogEndpoint {
    public static final Map<String, Session> onlineUsers = new ConcurrentHashMap<>();

    private String userid;

    @OnOpen
    //标记当WebSocket连接打开时调用的方法。
    public void onOpen(Session session, @PathParam("userid")String userid) {
        this.userid = userid;
        onlineUsers.put(userid,session);
    }

    @OnMessage
    public void onMessage(String message){

    }

    @OnClose
    public void onClose(Session session){
        onlineUsers.remove(this.userid);
    }

}
