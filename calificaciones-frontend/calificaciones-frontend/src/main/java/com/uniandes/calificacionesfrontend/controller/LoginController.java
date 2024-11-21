package com.uniandes.calificacionesfrontend.controller;

import com.uniandes.calificacionesfrontend.service.AuthService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final AuthService authService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody LoginRequest request, HttpSession session) {
        try {
            log.info("Intentando login para usuario: {}", request.username);
            String token = authService.signin(request.username, request.password);

            // Almacenar token en sesión
            session.setAttribute("token", token);
            session.setAttribute("username", request.username);

            log.info("Token almacenado en sesión. Longitud del token: {}", token.length());

            return "redirect:/home";
        } catch (Exception e) {
            log.error("Error en login: ", e);
            return "redirect:/login?error";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    public static class LoginRequest {
        public String username;
        public String password;
    }
}