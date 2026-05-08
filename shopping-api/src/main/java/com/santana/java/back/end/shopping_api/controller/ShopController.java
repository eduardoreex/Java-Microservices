package com.santana.java.back.end.shopping_api.controller;

import com.santana.java.back.end.shopping_api.dto.ShopDTO;
import com.santana.java.back.end.shopping_api.model.Shop;
import com.santana.java.back.end.shopping_api.repository.ShopRepository;
import com.santana.java.back.end.shopping_api.service.ShopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/shopping")
public class ShopController {


    @Autowired
    private ShopService shopService;

    @GetMapping
    public List<ShopDTO> getShops() {
        return shopService.getAll();
    }

    @GetMapping("/shopByUser/{userIdentifier}")
    public List<ShopDTO> getShopsByUser(@PathVariable String userIdentifier) {
        return shopService.getByUser(userIdentifier);
    }

    @PostMapping
    public ShopDTO newShop(@Valid @RequestBody ShopDTO shopDTO) {
        return shopService.save(shopDTO);
    }

    @GetMapping("/search")
    public List<ShopDTO> getShopsByFilter(
            @RequestParam(name = "data", required = true)
            @org.springframework.format.annotation.DateTimeFormat(pattern = "dd/MM/yyyy") Date data) {

        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setDate(data);
        return shopService.getByDate(shopDTO);
    }
}