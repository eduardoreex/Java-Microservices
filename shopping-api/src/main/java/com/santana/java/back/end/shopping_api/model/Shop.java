package com.santana.java.back.end.shopping_api.model;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

// @Entity avisa: "Esta classe é o espelho exato da tabela 'shop' no PostgreSQL!"
@Entity(name="shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    // Código do usuário que comprou
    private  String userIdentifier;
    // Valor total
    private  float total;
    // Data exata da compra
    private Date data;

    // 🚨 A LISTA DE ITENS (A MÁGICA DA ORQUESTRAÇÃO) 🚨
    // Lembra do estacionamento? A 'List<Item>' é um estacionamento que guarda vários itens dentro desta única compra!

    // @ElementCollection avisa: "Java, isto não é um dado simples (como texto). É uma coleção de filhos (@Embeddable)."
    // fetch = FetchType.EAGER diz: "Sempre que você for no banco buscar a Compra, traga os Itens dela JUNTOS e imediatamente."
    @ElementCollection(fetch = FetchType.EAGER)

    // @CollectionTable ensina o Java ONDE estão os itens no banco:
    // name = "item" -> "Estão na tabela chamada 'item'"
    // joinColumns = @JoinColumn(name = "shop_id") -> "A corda que amarra o item à compra é a coluna 'shop_id'"
    @CollectionTable(name = "item", joinColumns = @JoinColumn(name = "shop_id"))

    private List<Item> items;


    // --- GETTERS E SETTERS (As portas de acesso) ---

    public long getId() {
        return id;
    }
    public Date getData() {
        return data;
    }
    public float getTotal() {
        return total;
    }
    // Devolve o estacionamento inteiro de itens
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
    // Grava um estacionamento inteiro de itens novo
    public void setItems(List<Item> items) {
        this.items = items;
    }
    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }
}
