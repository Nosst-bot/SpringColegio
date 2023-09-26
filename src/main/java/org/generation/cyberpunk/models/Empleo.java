package org.generation.cyberpunk.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "empleos")
public class Empleo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empleo_id")
    private long empleoID;


    @Column(name = "nombre", length = 15)
    private String nombre;

    @Column(name = "sueldo")
    private int sueldo;

    @OneToOne
    @JsonManagedReference
    private Estudiante estudiante;

    public Empleo() {
    }

    public Empleo(long empleoID, String nombre, int sueldo, Estudiante estudiante) {
        this.empleoID = empleoID;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.estudiante = estudiante;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public long getEmpleoID() {
        return empleoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }
}
