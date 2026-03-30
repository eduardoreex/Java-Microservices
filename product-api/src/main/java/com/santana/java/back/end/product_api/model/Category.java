// Indica o "endereço" exato desta classe dentro da estrutura de pastas do seu projeto.
package com.santana.java.back.end.product_api.model;

// As linhas 'import' são como ir na caixa de ferramentas do Spring Boot e pegar as chaves de fenda necessárias para esta classe funcionar.
import com.santana.java.back.end.product_api.dto.CategoryDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// A anotação @Entity é a "etiqueta mágica" do Hibernate. Ela avisa o Spring: "Ei, esta classe não é um código comum, ela é o espelho da tabela 'category' lá no banco de dados".
@Entity(name="category")
public class Category { // 'public' significa que outras classes podem ver esta. 'class Category' cria o molde da nossa Categoria.

    // A anotação @Id avisa que a variável logo abaixo (o 'id') é a Chave Primária da tabela (o identificador único).
    @Id
    // @GeneratedValue avisa que o Java NÃO deve criar esse número. O (strategy = GenerationType.IDENTITY) delega a responsabilidade de contar (1, 2, 3...) para o banco de dados (o bigserial que usamos no SQL).
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // 'private' tranca a variável para não ser bagunçada de fora. 'long' é um tipo de número inteiro grande para suportar milhões de categorias.

    // Tranca a variável 'nome', que é texto (String), representando a coluna 'nome' da tabela.
    private String nome;

    // --- DAQUI PARA BAIXO SÃO OS GETTERS E SETTERS ---
    // Como as variáveis acima são 'private' (trancadas), o Java exige a criação de "portas de acesso" seguras.

    // O metodo 'get' serve apenas para LEITURA. Ele pega o valor que está lá dentro e entrega.
    public long getId() {
        return id;
    }

    // O metodo 'set' serve para gravacao. Ele recebe um valor de fora (long id) e injeta (this.id = id) na variável trancada da classe.
    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // --- O TRADUTOR ---
    // O metodo abaixo é 'static', o que significa que podemos usá-lo sem precisar criar um "new Category()".
    // A função dele é receber um pacote da internet (CategoryDTO) e traduzir (desempacotar) para o formato que o banco entende (Category).
    public static Category convert(CategoryDTO categoryDTO) {
        Category category = new Category(); // Cria uma categoria nova e vazia.
        category.setId(categoryDTO.getId()); // Pega o ID da caixa da internet e guarda na nova categoria.
        category.setNome(categoryDTO.getNome()); // Pega o NOME da caixa da internet e guarda na nova categoria.
        return category; // Devolve a categoria preenchida e pronta para ser salva no banco!
    }
}