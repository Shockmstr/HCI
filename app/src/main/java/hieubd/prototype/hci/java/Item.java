package hieubd.prototype.hci.java;

import java.io.Serializable;

public class Item implements Serializable, Comparable<Item> {
    public int resId;
    public String title;
    public String weight;
    public String address;
    public String note;
    public int price;
    public Item() {
    }

    public Item(int resId, String title, String weight, String address, int price, String note) {
        this.resId = resId;
        this.title = title;
        this.weight = weight;
        this.address = address;
        this.price = price;
        this.note = note;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Item o) {
        try {
            float thisWeight = Float.parseFloat(weight);
            float oWeight = Float.parseFloat(o.weight);
            if (thisWeight > oWeight) return 1;
            else if (thisWeight < oWeight) return -1;
            else return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
