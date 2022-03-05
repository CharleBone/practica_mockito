package org.charly.mockito.app.service;

import org.charly.mockito.app.models.Examen;
import org.charly.mockito.app.repository.ExamenRepository;
import org.charly.mockito.app.repository.PreguntaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExamenServiceImpleTest {

    @Mock
    ExamenRepository examenRepository;

    @Mock
    PreguntaRepository preguntaRepository;

    @InjectMocks
    ExamenServiceImple service;


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

    @Test
    void testGuardarExamen(){
        Examen nuevoExamen = new Examen(11L, "Gym");
        nuevoExamen.setPreguntas(Arrays.asList("musculacion", "cardio", "calisstenia"));
        service.guardar(nuevoExamen);
        assertNotNull(nuevoExamen.getId());
        verify(examenRepository).guardarExamen(any(Examen.class));
        verify(preguntaRepository).guardarPreguntas(anyList());
    }
}