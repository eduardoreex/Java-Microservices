package com.santana.java.back.end.user_api.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.santana.java.back.end.user_api.dto.UserDTO;
import com.santana.java.back.end.user_api.model.User;
import com.santana.java.back.end.user_api.repository.UserRepository;

@Service //
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> usuarios = userRepository.findAll();
        return usuarios
                .stream()
                .map(UserDTO::convert)
                .collect(Collectors.toList());
    }
    public UserDTO findById(long userId) {
        Optional<User> usuario = userRepository.findById(userId);

        if (usuario.isPresent()) {
            return UserDTO.convert(usuario.get());
        }
        return null;
    }
    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(User.convert(userDTO));
        return UserDTO.convert(user);
    }
    public UserDTO delete(long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
        return null;
    }
}
