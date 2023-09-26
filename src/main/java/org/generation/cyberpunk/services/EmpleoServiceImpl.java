package org.generation.cyberpunk.services;

import org.generation.cyberpunk.models.Empleo;
import org.generation.cyberpunk.repositories.EmpleoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleoServiceImpl implements EmpleoService{

    @Autowired
    EmpleoRepository empleoRepository;
    @Override
    public List<Empleo> listaDeEmpleos() {
        return empleoRepository.findAll();
    }

    @Override
    public Empleo guardarEmpleo(Empleo empleoNuevo) {
        return empleoRepository.save(empleoNuevo);
    }

    @Override
    public void borrarEmpleo(Long id) {
        empleoRepository.deleteById(id);
    }

    @Override
    public Empleo buscarEmpleoPorId(long id) {
        return null;
    }

    @Override
    public Empleo editarEmpleoPorId(Long id, Empleo empleo) {
        return null;
    }
}
