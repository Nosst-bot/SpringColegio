package org.generation.cyberpunk.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curso_id")
    private long cursoID;

    @Column(name = "nombre", length = 15)
    private String nombre;

    @Column(name = "profesor", length = 15)
    @NotNull
    private String profesor;

    @Column(name = "tema", length = 15)
    private String tema;

    @Column(name = "anio", precision = 4)
    private int fecha;


    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Estudiante> estudiantes;

    public Curso() {
    }

    public Curso(long cursoID) {
        this.cursoID = cursoID;
    }

    public Curso(long cursoID, String nombre, String profesor, String tema, int fecha) {
        this.cursoID = cursoID;
        this.nombre = nombre;
        this.profesor = profesor;
        this.tema = tema;
        this.fecha = fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public long getCursoID() {
        return cursoID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public String getTema() {
        return tema;
    }

    public int getFecha() {
        return fecha;
    }
}
