package com.santana.java.back.end.user_api.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.santana.java.back.end.user_api.dto.UserDTO;
import com.santana.java.back.end.user_api.model.User;
import com.santana.java.back.end.user_api.repository.UserRepository;

@Service // 1. Indica que esta classe contém a lógica de negócio [cite: 3017, 3021]
public class UserService {

    @Autowired // 2. O Spring "entrega" o repositório pronto aqui [cite: 3023, 3033]
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> usuarios = userRepository.findAll(); // 3. Busca tudo no banco [cite: 3026, 3036]
        return usuarios
                .stream() // 4. Inicia o processamento da lista [cite: 3027, 3037]
                .map(UserDTO::convert) // 5. Transforma cada User (Banco) em UserDTO (Web)
                .collect(Collectors.toList()); // 6. Fecha a lista e retorna [cite: 3029, 3039]
    }
}