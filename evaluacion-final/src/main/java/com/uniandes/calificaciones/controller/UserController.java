package com.uniandes.calificaciones.controller;

import com.uniandes.calificaciones.model.User;
import com.uniandes.calificaciones.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDTO loginDTO) {
        String token = userService.signin(loginDTO.username(), loginDTO.password());
        return ResponseEntity.ok(new AuthResponse(loginDTO.username(), token));
    }

    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody User user) {
        String token = userService.signup(user);
        return ResponseEntity.ok(new AuthResponse(user.getUsername(), token));
    }
}

record AuthResponse(String username, String token) {}
record LoginDTO(String username, String password) {}