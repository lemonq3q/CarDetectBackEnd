package com.example.test.entity;

import java.sql.Timestamp;

public class NowPosition {
    private String cardId;
    private Timestamp timestamp;
    private String workshop;

    public NowPosition(String cardId, Timestamp timestamp, String workshop) {
        this.cardId = cardId;
        this.timestamp = timestamp;
        this.workshop = workshop;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "NowPosition{" +
                "cardId='" + cardId + '\'' +
                ", timestamp=" + timestamp +
                ", workshop='" + workshop + '\'' +
                '}';
    }
}
