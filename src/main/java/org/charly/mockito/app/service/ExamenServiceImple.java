package org.charly.mockito.app.service;

import org.charly.mockito.app.models.Examen;
import org.charly.mockito.app.repository.ExamenRepository;

import java.util.Optional;

public class ExamenServiceImple implements ExamenService {

    private ExamenRepository examenRepository;

    public ExamenServiceImple(ExamenRepository examenRepository) {
        this.examenRepository = examenRepository;
    }

    @Override
    public Optional<Examen> buscarExamenPorNombre(String nombre) {
        return examenRepository.buscarTodo().stream().
                filter(examen -> examen.getNombre().equals(nombre))
                .findFirst();
    }
}
