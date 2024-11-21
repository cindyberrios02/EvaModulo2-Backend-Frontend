package com.uniandes.calificaciones.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean isValidRut(String rut) {
        // Implementar validación de RUT chileno
        if (rut == null || rut.trim().isEmpty()) {
            return false;
        }

        rut = rut.replace(".", "").replace("-", "");

        try {
            String rutNumber = rut.substring(0, rut.length() - 1);
            char dv = rut.charAt(rut.length() - 1);

            return checkRutDigit(Integer.parseInt(rutNumber), dv);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkRutDigit(int rut, char dv) {
        int m = 0, s = 1;
        for (; rut != 0; rut /= 10) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
        }
        return dv == (char) (s != 0 ? s + 47 : 75);
    }
}