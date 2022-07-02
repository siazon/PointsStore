package com.tus.pointsstore.Model;

public class Gift {
    private int id;
    private String name;
    private String info;
    private int price;
    private int stock;
    private String pic;

    public Gift(int id, String name, String info, int price, int stock, String pic) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.price = price;
        this.stock = stock;
        this.pic = pic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
