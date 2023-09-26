package org.generation.cyberpunk.services;

import jakarta.transaction.Transactional;
import org.generation.cyberpunk.models.Curso;
import org.generation.cyberpunk.models.Estudiante;
import org.generation.cyberpunk.repositories.CursoRepository;
import org.generation.cyberpunk.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Service
public class EstudianteServiceImpl implements EstudianteService{

    @Autowired
    EstudianteRepository estudianteRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public List<Estudiante> listaDeEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudianteNuevo){
        //Esta linea va a buscar en la base de datos si existe un curso con el ID a registrar para el estudiante
        //Optional es un objeto que nos sirve para evitar errores de Null, es decir,
        //se va a ejecutar de todas formas y si es null, el optional estara vacio.
        Optional<Curso> cursoOptional = cursoRepository.findById(estudianteNuevo.getCurso().getCursoID());

        //Verificar si es que el estudiante es mayor de edad
            if (estudianteNuevo.getEstudianteEdad() < 18) {
                System.out.println("El estudiante debe ser mayor a 18 años");
                return null;
            } else
                if(cursoOptional.isPresent()){ //Verificar si hay un curso almacenado en el Optional(Linea 36)
                estudianteNuevo.setCurso(cursoOptional.get());
                return estudianteRepository.save(estudianteNuevo);
            }else {
                System.out.println("El curso asignado no existe.");
                return null;
            }
        }

        //metodo para borrar segun id de estudiante.
    @Override
    public void borrarEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public Estudiante buscarEstudiantePorId(long id) {
        boolean existe = estudianteRepository.existsById(id);

        if (existe) {
            return estudianteRepository.findById(id).get();
        } else {
            System.out.println("El id es invalido o no existe.");
            return null;
        }
    }

    @Override
    public Estudiante editarEstudiantePorId(Long id, Estudiante estudianteActualizado) {
        boolean existe = estudianteRepository.existsById(id);

        if (existe) {
            Estudiante estudianteSeleccionado = estudianteRepository.findById(id).get();
            estudianteSeleccionado.setEstudianteEdad(estudianteActualizado.getEstudianteEdad());
            estudianteSeleccionado.setEstudianteNombre(estudianteActualizado.getEstudianteNombre());
            estudianteSeleccionado.setEmail(estudianteActualizado.getEmail());

            return estudianteRepository.save(estudianteSeleccionado);
        } else {
            System.out.println("No se encuentra el estudiante con ese ID");
            return null;
        }
    }

}

