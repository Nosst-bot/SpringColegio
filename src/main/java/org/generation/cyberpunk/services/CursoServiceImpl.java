package org.generation.cyberpunk.services;

import org.generation.cyberpunk.models.Curso;
import org.generation.cyberpunk.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    CursoRepository cursoRepository;
    @Override
    public List<Curso> listaDeCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso guardarCurso(Curso cursoNuevo) {
        return cursoRepository.save(cursoNuevo);
    }

    @Override
    public void borrarCurso(Long id) {
            cursoRepository.deleteById(id);
    }

    @Override
    public Curso buscarCursoPorId(long id) {
        boolean existe = cursoRepository.existsById(id);
        if (existe) {
            return cursoRepository.findById(id).get();
        }else {
            System.out.println("No se ha encontrado un curso con ese ID");
            return null;
        }
    }

    @Override
    public Curso editarCursoPorId(Long id, Curso curso) {
        if (cursoRepository.existsById(id) && cursoRepository.findById(id).isPresent()) {
            Curso nuevoCurso = cursoRepository.findById(id).get();
            nuevoCurso.setNombre(curso.getNombre());
            nuevoCurso.setProfesor(curso.getProfesor());
            nuevoCurso.setTema(curso.getTema());
            nuevoCurso.setFecha(curso.getFecha());

            return cursoRepository.save(nuevoCurso);
        }
        System.out.println("No se encuentra un curso con ese ID, intentalo otra vez.");
        return null;
    }
}
