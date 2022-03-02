package org.charly.mockito.app.repository;

import java.util.List;

public interface PreguntaRepository {
    List<String> buscarPreguntasPorExamenId(Long id);
}
