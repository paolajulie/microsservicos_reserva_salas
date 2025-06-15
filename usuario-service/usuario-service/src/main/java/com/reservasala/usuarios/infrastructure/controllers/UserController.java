package com.reservasala.usuarios.infrastructure.controllers;

import com.reservasala.usuarios.application.service.UserService;
import com.reservasala.usuarios.domain.models.Usuario;
import com.reservasala.usuarios.shared.dto.CreateUserRequest;
import com.reservasala.usuarios.shared.dto.UpdateUserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Usuario> create(@Valid @RequestBody CreateUserRequest request) {
        Usuario usuario = userService.createUsers(request);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public List<Usuario> list() {
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody UpdateUserRequest request) {
        Usuario updatedUser = userService.updateUser(id, request);
        return ResponseEntity.ok(updatedUser);
    }
}



