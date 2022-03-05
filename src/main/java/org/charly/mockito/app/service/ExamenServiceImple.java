package org.charly.mockito.app.service;

import org.charly.mockito.app.models.Examen;
import org.charly.mockito.app.repository.ExamenRepository;
import org.charly.mockito.app.repository.PreguntaRepository;

import java.util.List;
import java.util.Optional;

public class ExamenServiceImple implements ExamenService {

    private ExamenRepository examenRepository;
    private PreguntaRepository preguntaRepository;

    public ExamenServiceImple(ExamenRepository examenRepository, PreguntaRepository preguntaRepository) {
        this.examenRepository = examenRepository;
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public Optional<Examen> buscarExamenPorNombre(String nombre) {
        return examenRepository.buscarTodo().stream().
                filter(examen -> examen.getNombre().equals(nombre))
                .findFirst();
    }

    @Override
    public Optional<Examen> buscarExamenPorNombreConPreguntas(String nombre) {
        Optional<Examen> examenOptional = buscarExamenPorNombre(nombre);
        if(!examenOptional.isPresent()){
            return null;
        }
        List<String> preguntas = preguntaRepository.buscarPreguntasPorExamenId(examenOptional.orElseThrow().getId());
        examenOptional.orElseThrow().setPreguntas(preguntas);
        return examenOptional;
    }

    @Override
    public Examen guardar(Examen examen) {
        if (!examen.getPreguntas().isEmpty()) {
            preguntaRepository.guardarPreguntas(examen.getPreguntas());
        }
        return examenRepository.guardarExamen(examen);
    }
}
