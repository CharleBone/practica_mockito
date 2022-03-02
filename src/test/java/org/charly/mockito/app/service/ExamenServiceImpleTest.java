package org.charly.mockito.app.service;

import org.charly.mockito.app.models.Examen;
import org.charly.mockito.app.repository.ExamenRepository;
import org.charly.mockito.app.repository.PreguntaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ExamenServiceImpleTest {

    ExamenRepository examenRepository;
    PreguntaRepository preguntaRepository;
    ExamenService service;

    @BeforeEach
    void setupMethod() {
        ExamenRepository examenRepository = mock(ExamenRepository.class);
        PreguntaRepository preguntaRepository = mock(PreguntaRepository.class);
        ExamenService service = new ExamenServiceImple(examenRepository, preguntaRepository);
    }

    @Test
    void buscarExamenPorNombre() {
        when(examenRepository.buscarTodo()).thenReturn(Datos.EXAMENES);
        Optional<Examen> examen = service.buscarExamenPorNombre("Ingles");
        assertEquals(7L, examen.orElseThrow().getId());
        assertEquals(examen.orElseThrow().getNombre(), "Ingles");
    }

    @Test
    void testPreguntasExamen(){
        when(examenRepository.buscarTodo()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.buscarPreguntasPorExamenId(3L)).thenReturn(Datos.PREGUNTAS);
        Optional<Examen> examenOptional = service.buscarExamenPorNombreConPreguntas("Matematicas");
        System.out.println(examenOptional.orElseThrow().getPreguntas());
    }
}