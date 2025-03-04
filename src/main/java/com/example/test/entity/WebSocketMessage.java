package com.example.test.entity;

public class WebSocketMessage {
    private int type;
    private Object message;

    public WebSocketMessage(int type, Object message) {
        this.type = type;
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "WebSocketMessage{" +
                "type=" + type +
                ", message=" + message +
                '}';
    }
}
