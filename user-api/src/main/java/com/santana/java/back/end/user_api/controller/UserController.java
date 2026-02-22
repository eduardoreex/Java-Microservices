package com.santana.java.back.end.user_api.controller;

import com.santana.java.back.end.user_api.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    public static List<UserDTO> usuarios = new ArrayList<UserDTO>();

    @PostConstruct
    public void initiateList() {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Eduardo");
        userDTO.setCpf("621");
        userDTO.setEmail("eduardo@gmail.com");
        userDTO.setEndereco("Rua a");
        userDTO.setTelefone("86988589423");
        userDTO.setDataCadastro(new Date());

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setNome("Luiz");
        userDTO2.setCpf("145");
        userDTO2.setEmail("luizo@gmail.com");
        userDTO2.setEndereco("Rua b");
        userDTO2.setTelefone("86887484904");
        userDTO2.setDataCadastro(new Date());


        UserDTO userDTO3 = new UserDTO();
        userDTO3.setNome("bruno");
        userDTO3.setCpf("445");
        userDTO3.setEmail("Bruno@gmail.com");
        userDTO3.setEndereco("Rua w");
        userDTO3.setTelefone("868379936863");
        userDTO3.setDataCadastro(new Date());

        usuarios.add(userDTO);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);
    }

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return usuarios;
    }
}
