// O endereço desta classe. Ela mora na pasta 'dto'.
package com.santana.java.back.end.product_api.dto;

// Aqui importamos  a Validação!
import jakarta.validation.constraints.NotNull;
// Importamos a classe Category original para podermos fazer a conversão.
import com.santana.java.back.end.product_api.model.Category;

public class CategoryDTO {

    // @NotNull é o nosso "Leão de Chácara". Ele avisa o Spring:
    // "Se alguém tentar mandar um JSON sem o número do ID, bloqueie na porta e devolva um Erro 400 (Bad Request). Nem tente ir ao banco de dados!"
    @NotNull
    private Long id;
    // O nome da categoria. Aqui não colocamos @NotNull porque, na hora de buscar um produto, às vezes só precisamos do ID da categoria.
    private String nome;

    // --- GETTERS E SETTERS ---
    // Mesma regra de antes: portas de acesso seguras para ler (get) e gravar (set) os dados na nossa caixa de transporte.
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

    // --- O TRADUTOR INVERSO ---
    // Este metodo faz o caminho contrário da Entidade.
    // Ele pega uma Category (que acabou de sair do banco de dados) e a empacota dentro de um CategoryDTO para podermos enviar com segurança para a tela do usuário.
    public static CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO(); // Monta a caixa de papelão vazia.
        categoryDTO.setId(category.getId()); // Pega o ID do banco e põe na caixa.
        categoryDTO.setNome(category.getNome()); // Pega o NOME do banco e põe na caixa.
        return categoryDTO; // Envia a caixa lacrada para a internet!
    }
}