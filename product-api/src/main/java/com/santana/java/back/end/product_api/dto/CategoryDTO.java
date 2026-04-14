package com.santana.java.back.end.product_api.dto;

import jakarta.validation.constraints.NotNull;
import com.santana.java.back.end.product_api.model.Category;

public class CategoryDTO {

    @NotNull
    private Long id;
    private String nome;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public static CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());

        categoryDTO.setNome(category.getNome());
        return categoryDTO;
    }
}