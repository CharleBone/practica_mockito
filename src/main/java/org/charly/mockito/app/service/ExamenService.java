package org.charly.mockito.app.service;

import org.charly.mockito.app.models.Examen;

import java.util.Optional;

public interface ExamenService {

    Optional<Examen> buscarExamenPorNombre(String nombre);

}
