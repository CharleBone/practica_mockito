package org.charly.mockito.app.repository;

import org.charly.mockito.app.models.Examen;

import java.util.List;

public interface ExamenRepository {

    List<Examen> buscarTodo();

    Examen guardarExamen(Examen examen);
}
