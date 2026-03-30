package com.santana.java.back.end.product_api.dto;

import com.santana.java.back.end.product_api.model.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDTO {

    // @NotBlank: É o fiscal mais rigoroso. Ele bloqueia o texto se for nulo (null) e TAMBÉM bloqueia se for apenas um espaço em branco (" ").
    @NotBlank
    private String productIdentifier;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    // @NotNull: É o fiscal padrão. Usamos para números (Float) ou objetos (CategoryDTO), pois o @NotBlank só funciona para textos (String).
    @NotNull
    private Float preco;

    @NotNull
    private CategoryDTO category; // Dentro da caixa de Produto, viaja uma caixa menor de Categoria!

    // --- GETTERS E SETTERS (Gere com o IntelliJ - Alt + Insert) ---
    public String getProductIdentifier() { return productIdentifier; }
    public void setProductIdentifier(String productIdentifier) { this.productIdentifier = productIdentifier; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Float getPreco() { return preco; }
    public void setPreco(Float preco) { this.preco = preco; }
    public CategoryDTO getCategory() { return category; }
    public void setCategory(CategoryDTO category) { this.category = category; }

    // --- O TRADUTOR INVERSO ---
    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setProductIdentifier(product.getProductIdentifier());
        productDTO.setDescricao(product.getDescricao());

        if (product.getCategory() != null) {
            productDTO.setCategory(CategoryDTO.convert(product.getCategory()));
        }
        return productDTO;
    }
}