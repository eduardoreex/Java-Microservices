package com.santana.java.back.end.shopping_api.service;

import com.santana.java.back.end.shopping_api.dto.ShopDTO;
import com.santana.java.back.end.shopping_api.model.Shop;
import com.santana.java.back.end.shopping_api.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public List<ShopDTO> getAll() {
        return shopRepository.findAll()
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public ShopDTO save(ShopDTO shopDTO) {
        shopDTO.setDate(new Date());

        Shop shop = Shop.convert(shopDTO);

        shop = shopRepository.save(shop);

        return ShopDTO.convert(shop);
    }
}