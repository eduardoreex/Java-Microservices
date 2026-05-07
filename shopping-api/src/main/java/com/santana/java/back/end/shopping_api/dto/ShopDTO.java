package com.santana.java.back.end.shopping_api.dto;

import com.santana.java.back.end.shopping_api.model.Shop;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ShopDTO {

    @NotBlank
    private String userIdentifier;

    @NotNull
    private Float total;

    @NotNull
    private Date date;


    @NotNull
    private List<ItemDTO> items;

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public Date getDate() {
        return date;
    }

    public Float getTotal() {
        return total;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public static ShopDTO convert(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setTotal(shopDTO.getTotal());
        shopDTO.setDate(shopDTO.getDate());
        if (shop.getItems() != null) {
            shopDTO.setItems(shop.getItems().stream().map(ItemDTO::convert).collect((Collectors.toList())));
        }
        return shopDTO;
    }
}
