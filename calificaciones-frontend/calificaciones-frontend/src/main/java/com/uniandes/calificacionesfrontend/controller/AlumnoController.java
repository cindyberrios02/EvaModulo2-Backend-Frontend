package com.uniandes.calificacionesfrontend.controller;

import com.uniandes.calificacionesfrontend.service.AlumnoService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class AlumnoController {

    private final AlumnoService alumnoService;

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        String token = (String) session.getAttribute("token");
        String username = (String) session.getAttribute("username");

        log.info("Accediendo a /home. Usuario: {}, Token presente: {}",
                username, (token != null ? "Sí" : "No"));

        if (token == null) {
            log.warn("No se encontró token en la sesión");
            return "redirect:/login";
        }

        try {
            model.addAttribute("alumnos", alumnoService.findAll(token));
            model.addAttribute("username", username);
            return "home";
        } catch (Exception e) {
            log.error("Error al obtener alumnos con token: {}", token, e);
            session.invalidate();
            return "redirect:/login";
        }
    }
}