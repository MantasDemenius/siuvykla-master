package com.example.mokytojas.siuvykla;


public class Drabuzis {

    private String type, gender, color, delivery;
    private double order, price, length, width;

    public Drabuzis(String type, String gender, String color, String delivery, double order, double price, double length, double width) {
        this.type = type;
        this.gender = gender;
        this.color = color;
        this.delivery = delivery;
        this.order = order;
        this.price = price;
        this.length = length;
        this.width = width;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public double getOrder() {
        return order;
    }

    public void setOrder(double order) {
        this.order = order;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
