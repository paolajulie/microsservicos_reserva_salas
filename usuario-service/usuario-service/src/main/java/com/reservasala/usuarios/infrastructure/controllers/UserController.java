package com.reservasala.usuarios.infrastructure.controllers;

import com.reservasala.usuarios.application.service.UserService;
import com.reservasala.usuarios.domain.models.Usuario;
import com.reservasala.usuarios.shared.dto.CreateUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @PostMapping
    public Usuario create(@RequestBody CreateUserRequest request) {
        return userService.createUsers(request);
    }

    @GetMapping
    public List<Usuario> list() {
        return userService.listUsers();
    }
}



