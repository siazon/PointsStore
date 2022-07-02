package com.tus.pointsstore.Model;

public class Exchange_his {
    private int id;
    private int gift_id;
    private int user_id;
    private int qty;
    private int amount;
    private String time;
    private String address;
    private String delivery;

    public Exchange_his(int id, int gift_id, int user_id, int qty, int amount, String time, String address, String delivery) {
        this.id = id;
        this.gift_id = gift_id;
        this.user_id = user_id;
        this.qty = qty;
        this.amount = amount;
        this.time = time;
        this.address = address;
        this.delivery = delivery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGift_id() {
        return gift_id;
    }

    public void setGift_id(int gift_id) {
        this.gift_id = gift_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }
}
