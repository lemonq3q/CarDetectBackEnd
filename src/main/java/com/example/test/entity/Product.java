package com.example.test.entity;

public class Product {
    private String workshop;
    private int target;
    private int complete;
    private int wrong;

    public Product(String workshop, int target, int complete, int wrong) {
        this.workshop = workshop;
        this.target = target;
        this.complete = complete;
        this.wrong = wrong;
    }

    public String getWorkshop() {
        return workshop;
    }

    public void setWorkshop(String workshop) {
        this.workshop = workshop;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }

    public int getWrong() {
        return wrong;
    }

    public void setWrong(int wrong) {
        this.wrong = wrong;
    }

    @Override
    public String toString() {
        return "Product{" +
                "workshop='" + workshop + '\'' +
                ", target=" + target +
                ", complete=" + complete +
                ", wrong=" + wrong +
                '}';
    }
}
