package org.generation.cyberpunk.services;

import org.generation.cyberpunk.models.Estudiante;

import java.util.List;

public interface EstudianteService {

    List<Estudiante> listaDeEstudiantes();

    Estudiante guardarEstudiante(Estudiante estudianteNuevo);

    void borrarEstudiante(Long id);

    Estudiante buscarEstudiantePorId(long id);

    Estudiante editarEstudiantePorId(Long id, Estudiante estudiante);
}
