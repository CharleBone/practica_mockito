package org.charly.mockito.app.service;

import org.charly.mockito.app.models.Examen;
import org.charly.mockito.app.repository.ExamenRepository;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ExamenServiceImpleTest {

    @Test
    void buscarExamenPorNombre() {
        ExamenRepository repository = mock(ExamenRepository.class);
        ExamenService service = new ExamenServiceImple(repository);
        List<Examen> data = Arrays.asList(new Examen(5L, "Matematicas"),
                new Examen(6L, "Historia"),
                new Examen(7L, "Ingles"));

        when(repository.buscarTodo()).thenReturn(data);
        Optional<Examen> examen = service.buscarExamenPorNombre("Ingles");
        assertEquals(7L, examen.orElseThrow().getId());
        assertEquals(examen.orElseThrow().getNombre(), "Ingles");
    }
}