package com.santana.java.back.end.user_api.controller;

import com.santana.java.back.end.user_api.dto.UserDTO;
import com.santana.java.back.end.user_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService; // O Controller agora usa o Serviço [cite: 3089-3090]

    @GetMapping("/user/")
    public List<UserDTO> getUsers() {
        return userService.getAll(); // Busca direto no Banco via Serviço [cite: 3092, 3094]
    }

    @GetMapping("/user/{id}")
    public UserDTO findById(@PathVariable Long id) {
        return userService.findById(id); // Busca por ID [cite: 3095-3096]
    }

    @PostMapping("/user")
    public UserDTO newUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO); // Salva no Banco [cite: 3098-3100]
    }

    @DeleteMapping("/user/{id}")
    public UserDTO delete(@PathVariable Long id) {
        return userService.delete(id); // Deleta do Banco [cite: 3105-3106]
    }
}