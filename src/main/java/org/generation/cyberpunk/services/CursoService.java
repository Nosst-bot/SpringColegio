package org.generation.cyberpunk.services;

import org.generation.cyberpunk.models.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> listaDeCursos();

    Curso guardarCurso(Curso cursoNuevo);

    void borrarCurso(Long id);

    Curso buscarCursoPorId(long id);

    Curso editarCursoPorId(Long id, Curso curso);
}
