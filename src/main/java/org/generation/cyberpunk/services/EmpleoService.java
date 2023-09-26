package org.generation.cyberpunk.services;

import org.generation.cyberpunk.models.Empleo;

import java.util.List;

public interface EmpleoService {
    List<Empleo> listaDeEmpleos();

    Empleo guardarEmpleo(Empleo empleoNuevo);

    void borrarEmpleo(Long id);

    Empleo buscarEmpleoPorId(long id);

    Empleo editarEmpleoPorId(Long id, Empleo empleo);
}
