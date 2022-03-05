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
        examenRepository = mock(ExamenRepository.class);
        preguntaRepository = mock(PreguntaRepository.class);
        service = new ExamenServiceImple(examenRepository, preguntaRepository);
    }

    @Test
    void buscarExamenPorNombre() {
        when(examenRepository.buscarTodo()).thenReturn(Datos.EXAMENES);
        Optional<Examen> examen = service.buscarExamenPorNombre("Matematicas");
        assertEquals(5L, examen.orElseThrow().getId());
        assertEquals(examen.orElseThrow().getNombre(), "Matematicas");
    }

    @Test
    void testPreguntasExamen(){
        when(examenRepository.buscarTodo()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.buscarPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Optional<Examen> examenOptional = service.buscarExamenPorNombreConPreguntas("Matematicas");
        assertEquals(examenOptional.orElseThrow().getPreguntas().size(), 5L);
        assertTrue(examenOptional.orElseThrow().getPreguntas().contains("integrales"));
    }

    @Test
    void testPreguntasExamenVerify(){
        when(examenRepository.buscarTodo()).thenReturn(Datos.EXAMENES);
        when(preguntaRepository.buscarPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Optional<Examen> examenOptional = service.buscarExamenPorNombreConPreguntas("Matematicas");
        verify(examenRepository).buscarTodo();
        verify(preguntaRepository).buscarPreguntasPorExamenId(5L);
    }
}