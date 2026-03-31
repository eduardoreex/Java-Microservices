package com.santana.java.back.end.product_api.controller;


import com.santana.java.back.end.product_api.dto.ProductDTO;
import com.santana.java.back.end.product_api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController

@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public List<ProductDTO> getProducts() {
        return productService.getAll();
    }


    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductBycategoryid(@PathVariable Long categoryId) {
        return productService.getProductByCategoryId(categoryId);

    }
    @GetMapping("/{productIdentifier}")
    public ProductDTO findById(@PathVariable String productIdentifier) {
        return productService.findByProductIdentifier(productIdentifier);
    }

    @PostMapping
    public ProductDTO newProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }

}
