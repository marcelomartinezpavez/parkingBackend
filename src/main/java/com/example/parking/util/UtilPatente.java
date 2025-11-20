package com.example.parking.util;

public class UtilPatente {
    public static boolean esPatenteValida(String patente) {
        if (patente == null)
            return false;

        String limpia = patente.trim().toUpperCase();

        // Formatos válidos
        String formatoAutoAntiguo = "^[A-Z]{2}[0-9]{4}$"; // Ej: AB1234
        String formatoAutoNuevo = "^[A-Z]{4}[0-9]{2}$"; // Ej: ABCD12
        String formatoMoto = "^[A-Z]{2}[0-9]{3}$"; // Ej: OR123

        return limpia.matches(formatoAutoAntiguo)
                || limpia.matches(formatoAutoNuevo)
                || limpia.matches(formatoMoto);
    }

}
