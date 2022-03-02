package org.charly.mockito.app.service;

import org.charly.mockito.app.models.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {

    public static final List<Examen> EXAMENES = Arrays.asList(new Examen(3L, "Matematicas"),
            new Examen(6L, "Historia"),
            new Examen(7L, "Ingles"));

    public static final List<String> PREGUNTAS = Arrays.asList("aritmetica", "integrales", "fisica");
}
