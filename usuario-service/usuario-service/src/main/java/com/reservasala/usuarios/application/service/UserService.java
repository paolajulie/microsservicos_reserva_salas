package com.reservasala.usuarios.application.service;

import com.reservasala.usuarios.domain.models.Usuario;
import com.reservasala.usuarios.infrastructure.repositories.UserRepository;
import com.reservasala.usuarios.shared.dto.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;

    public Usuario createUsers(CreateUserRequest  request) {
        Usuario usuario = Usuario.builder()
                .name(request.getName())
                .email(request.getEmail())
                .address(request.getAddress())
                .build();

        return userRepository.save(usuario);
    }

    public List<Usuario> listUsers() {
        return userRepository.findAll();
    }
}

