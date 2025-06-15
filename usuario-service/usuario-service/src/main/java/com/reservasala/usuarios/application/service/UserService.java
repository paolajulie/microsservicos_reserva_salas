package com.reservasala.usuarios.application.service;

import com.reservasala.usuarios.domain.models.Usuario;
import com.reservasala.usuarios.infrastructure.repositories.UserRepository;
import com.reservasala.usuarios.shared.dto.CreateUserRequest;
import com.reservasala.usuarios.shared.dto.UpdateUserRequest;
import com.reservasala.usuarios.shared.exceptions.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Usuario getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Transactional
    public Usuario updateUser(Long id, UpdateUserRequest request) {
        Usuario usuario = getUserById(id);
        
        if (request.getName() != null) {
            usuario.setName(request.getName());
        }
        if (request.getEmail() != null) {
            usuario.setEmail(request.getEmail());
        }
        if (request.getAddress() != null) {
            usuario.setAddress(request.getAddress());
        }
        
        return userRepository.save(usuario);
    }
}

