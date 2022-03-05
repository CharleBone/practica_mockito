package org.charly.mockito.app.service;

import org.charly.mockito.app.models.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {

    public static final List<Examen> EXAMENES = Arrays.asList(new Examen(5L, "Matematicas"),
            new Examen(7L, "Historia"),
            new Examen(9L, "Ingles"));

    public static final List<String> PREGUNTAS = Arrays.asList("aritmetica", "integrales", "fisica", "geometria", "trigonometria");
}
