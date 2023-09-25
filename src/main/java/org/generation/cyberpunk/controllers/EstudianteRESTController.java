package org.generation.cyberpunk.controllers;

import org.generation.cyberpunk.models.Curso;
import org.generation.cyberpunk.models.Estudiante;
import org.generation.cyberpunk.services.CursoService;
import org.generation.cyberpunk.services.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EstudianteRESTController {

    @Autowired
    EstudianteServiceImpl estudianteService;

    @GetMapping("/lista")
    public List<Estudiante> listaEstudiantes() {
        return estudianteService.listaDeEstudiantes();
    }

    @GetMapping("/estudiante/{id}")
    public Estudiante estudiantePorId(@PathVariable Long id) {
        return estudianteService.buscarEstudiantePorId(id);
    }

    @PostMapping("/estudiante/nuevo")
    public Estudiante guardarNuevoEstudiante(@RequestBody Estudiante estudiante){
        return estudianteService.guardarEstudiante(estudiante);
    }

    @DeleteMapping("/estudiante/borrar")
    public ResponseEntity<String> borrarEstudiantePorId(@RequestParam Long id){
        estudianteService.borrarEstudiante(id);
        return ResponseEntity.ok("Usuario eliminado con exito");
    }

    //para editar
    @PutMapping("/estudiante/editar/{id}")
    public Estudiante editarEstudiantePorId(@PathVariable long id,
                                            @RequestBody Estudiante estudianteActualizado) {

        return estudianteService.editarEstudiantePorId(id, estudianteActualizado);
    }


    //PARA EL CURSO
    @Autowired
    CursoService cursoService;

    @GetMapping("/cursos")
    public List<Curso> listaCursos(){
        return cursoService.listaDeCursos();
    }

    @PostMapping("/cursos/nuevo")
    public Curso nuevoCurso(@RequestBody Curso curso){
        return cursoService.guardarCurso(curso);
    }

}
