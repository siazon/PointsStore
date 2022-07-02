package com.tus.pointsstore.Model;

public class Exchange_info extends Exchange_his {
    private String name;
    private String info;
    private String pic;

    public Exchange_info(int id, int gift_id, int user_id, int qty, int amount, String time, String address, String delivery, String name, String info, String pic) {
        super(id, gift_id, user_id, qty, amount, time, address, delivery);
        this.name = name;
        this.info = info;
        this.pic = pic;
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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
