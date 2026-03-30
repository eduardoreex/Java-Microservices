package com.santana.java.back.end.product_api.model;

import com.santana.java.back.end.product_api.dto.CategoryDTO;
import com.santana.java.back.end.product_api.dto.ProductDTO;
import jakarta.persistence.*;

@Entity(name="product") // Etiqueta mágica: "Java esta classe é a tabela 'product'."
public class Product {

    @Id // Chave Primária.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco de dados gera o número sozinho.
    private long id;

    private String nome;
    private Float preco; // Usamos Float (com 'F' maiusculo) para permitir números com vírgula e também aceitar 'nulo' se precisarmos.
    private String descricao;
    private String productIdentifier; // O código de barras ou SKU do produto (ex: 'tv-samsung-55').

    // CHAVE ESTRANGEIRA ACONTECE AQUI!
    // @ManyToOne significa "Muitos para Um". Ou seja: MUITOS produtos podem pertencer a UMA mesma categoria.
    @ManyToOne
    // @JoinColumn diz ao Java: "A coluna lá no banco de dados que guarda essa ligação se chama 'category_id'".
    @JoinColumn(name = "category_id")
    private Category category; // O Java guarda a Categoria inteira aqui dentro, não apenas o número do ID!

    // --- GETTERS E SETTERS (Gere todos eles com o IntelliJ
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Float getPreco() { return preco; }
    public void setPreco(Float preco) { this.preco = preco; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getProductIdentifier() { return productIdentifier; }
    public void setProductIdentifier(String productIdentifier) { this.productIdentifier = productIdentifier; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    // --- O TRADUTOR ---
    public static Product convert(ProductDTO productDTO) {
        Product product = new Product();
        product.setNome(productDTO.getNome());
        product.setPreco(productDTO.getPreco());
        product.setDescricao(productDTO.getDescricao());
        product.setProductIdentifier(productDTO.getProductIdentifier());

        // A verificação de segurança: Só converte a categoria se ela vier dentro do DTO.
        if (productDTO.getCategory() != null) {
            product.setCategory(Category.convert(productDTO.getCategory()));
        }
        return product;
    }
}