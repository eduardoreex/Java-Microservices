package com.santana.java.back.end.shopping_api.repository;

import com.santana.java.back.end.shopping_api.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
}