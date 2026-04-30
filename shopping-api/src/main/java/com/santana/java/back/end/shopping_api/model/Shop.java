package com.santana.java.back.end.shopping_api.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity(name="shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String userIdentifier;
    private  float total;
    private Date data;


    @ElementCollection(fetch = FetchType.EAGER)


    @CollectionTable(name = "item", joinColumns = @JoinColumn(name = "shop_id"))

    private List<Item> items;

    public long getId() {
        return id;
    }
    public Date getData() {
        return data;
    }
    public float getTotal() {
        return total;
    }
    public List<Item> getItems() {
        return items;
    }
    public String getUserIdentifier() {
        return userIdentifier;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setTotal(float total) {
        this.total = total;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }
}
