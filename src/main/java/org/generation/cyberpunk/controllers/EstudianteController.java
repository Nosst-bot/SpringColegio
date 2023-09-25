package org.generation.cyberpunk.controllers;

import org.generation.cyberpunk.models.Estudiante;
import org.generation.cyberpunk.services.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller //Controlador
public class EstudianteController {
    /*
    GET
    POST
    PUT
    DELETE
    PATCH
     */

    @Autowired
    EstudianteServiceImpl estudianteService;

    @RequestMapping(value = "/estudiantes", method = RequestMethod.GET)
    public String enlistarEstudiantes(Model model) {
        List<Estudiante> listaEstudiantes = estudianteService.listaDeEstudiantes();
        model.addAttribute("estudiantes", listaEstudiantes);
        return "estudiantes";
    }


    @GetMapping("/registro")
    public String mostrarFormulario(Model model) { //Model sirve para mappear algun objeto a la vista que especificamos
        model.addAttribute("estudiante", new Estudiante());
        return "registro";
    }

    @PostMapping("/nuevo")
    public String guardarEstudiante(@ModelAttribute Estudiante nuevoEstudiante) {
        estudianteService.guardarEstudiante(nuevoEstudiante);
        return "redirect:/index";
    }

    @PostMapping("/borrar/{id}")
    public String borrarEstudiantePorId(@PathVariable Long id) {
        estudianteService.borrarEstudiante(id);
        return "redirect:/estudiantes";
    }

}
