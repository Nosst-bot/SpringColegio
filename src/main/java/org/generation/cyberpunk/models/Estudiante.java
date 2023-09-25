package org.generation.cyberpunk.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

//Le indicamos que esta es una entidad que debe mapearse a la BDD
//Asignar un nombre a la tabla
@Entity
@Table(name = "estudiantes_cyberpunk")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long estudianteID;

    @Column(name = "nombre")
    @NotNull
    private String estudianteNombre;

    @Min(value = 18, message = "No se puede ingresar menores de 18.")  //Viene de la librearia jakarta.validation
    @Max(value = 100, message = "No se puede agregar mayores que 100.")
    @NotNull
    private int estudianteEdad;

    @Email(message = "Ingrese un email valido")
    @NotNull
    private String email;


    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;



    public Estudiante() {
    }

    public Estudiante(Long estudianteID, String estudianteNombre, int estudianteEdad, String email, Curso curso) {
        this.estudianteID = estudianteID;
        this.estudianteNombre = estudianteNombre;
        this.estudianteEdad = estudianteEdad;
        this.email = email;
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Long getEstudianteID() {
        return estudianteID;
    }

    public String getEstudianteNombre() {
        return estudianteNombre;
    }

    public void setEstudianteNombre(String estudianteNombre) {
        this.estudianteNombre = estudianteNombre;
    }

    public int getEstudianteEdad() {
        return estudianteEdad;
    }

    public void setEstudianteEdad(int estudianteEdad) {
        this.estudianteEdad = estudianteEdad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
