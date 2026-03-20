package com.santana.java.back.end.user_api.model; // O IntelliJ vai te dar o nome certo

import jakarta.persistence.*;
import java.util.Date;
import com.santana.java.back.end.user_api.dto.UserDTO; // Importante para o metodo convert

@Entity(name = "user") // Nome da tabela no banco [cite: 2966]
public class  User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID automático [cite: 2969]
    private long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private Date dataCadastro;
    public static User convert(UserDTO userDTO) {
        User user = new User();
        user.setNome(userDTO.getNome());
        user.setEndereco(userDTO.getEndereco());
        user.setCpf(userDTO.getCpf());
        user.setEmail(userDTO.getEmail());
        user.setTelefone(userDTO.getTelefone());
        user.setDataCadastro(userDTO.getDataCadastro());
        return user;
    }
    public void setCpf(String cpf) {
    }
    public void setNome(String nome) {
    }
    public void setTelefone(String telefone) {
    }
    public void setEndereco(String endereco) {
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEmail() {
        return email;
    }
    public String getNome() {
        return nome;
    }
    public Date getDataCadastro() {
        return dataCadastro;
    }
}