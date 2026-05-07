package com.santana.java.back.end.shopping_api.model;

import com.santana.java.back.end.shopping_api.dto.ShopDTO;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity(name="shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String userIdentifier;
    private  float total;
    private Date date;

    @ElementCollection(fetch = FetchType.EAGER)

    @CollectionTable(name = "item", joinColumns = @JoinColumn(name = "shop_id"))

    private List<Item> items;

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public static Shop convert(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setUserIdentifier(shopDTO.getUserIdentifier());
        shop.setTotal(shopDTO.getTotal());
        shop.setDate(shopDTO.getDate());
        shop.setItems(shopDTO.getItems()
                .stream()
                .map(Item::convert)
                .collect(Collectors.toList()));
        return shop;
    }
}
