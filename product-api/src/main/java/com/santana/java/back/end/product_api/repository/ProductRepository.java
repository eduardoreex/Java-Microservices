package com.santana.java.back.end.product_api.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.santana.java.back.end.product_api.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //  O MÉTODODO SPRING
    // Repara no nome: 'findBy' (Procurar Por) + 'ProductIdentifier' (o nome exato da tua variável na classe Product).
    // O Spring é tão inteligente que só de leres isto, ele cria o SQL automático: "SELECT * FROM product WHERE product_identifier = ?"
    // Retorna apenas UM produto, porque o identificador é único.
    public Product findByProductIdentifier(String productIdentifier);

    //2. A CONSULTA CUSTOMIZADA (JPQL)
    // Às vezes, o Spring não consegue adivinhar o que queremos. Então usamos o @Query para escrevermos nós mesmos.
    // ATENÇÃO: Isto NÃO é SQL normal. É JPQL (Java Persistence Query Language).
    // Em vez de usar o nome das tabelas da base de dados, usamos o nome das tuas CLASSES e VARIÁVEIS do Java!
    @Query(value = "select p "                               // "Seleciona o Produto (que eu apelidei de 'p')"
            + "from product p "                                  // "Da classe product (p)"
            + "join category c on p.category.id = c.id "         // "Junta com a classe category (c) onde os IDs se cruzam"
            + "where c.id = :categoryId")                        // "Mas APENAS onde o ID da categoria for igual a :categoryId"

    // O que é o @Param? É a ponte! Ele pega no número (long) que entra no metodo e injeta-o lá em cima onde diz ":categoryId".
    // Retorna uma 'List<Product>' porque uma mesma categoria (ex: Eletrónicos) pode ter dezenas de produtos ligados a ela.
    public List<Product> getProductByCategory(@Param("categoryId") long categoryId);
}