package com.santana.java.back.end.shopping_api.model;

// Ferramenta do JPA (Banco de Dados)
import jakarta.persistence.Embeddable;


// @Embeddable é uma anotação MUITO importante!
// Ela diz: "Java, esta classe NÃO tem vida própria. Ela é um 'puxadinho'. Ela só existe se estiver embutida (dentro) de uma Compra (Shop)".
// É por isso que ela não tem @Id (Chave primária). O dono do ID é a Compra!
@Embeddable
public class Item {
    // private: trancado (só acessível por get/set). String: Texto.
    private String productIdentifier;
    // Float: Número com casas decimais (dinheiro).
    private float price;

    // --- PORTAS DE ACESSO (GETTERS E SETTERS) ---

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public float getPrice() {
        return price;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
