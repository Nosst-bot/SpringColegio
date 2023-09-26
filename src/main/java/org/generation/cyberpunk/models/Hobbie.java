package org.generation.cyberpunk.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hobbies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hobbie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hobby_id")
    private long hobbyID;

    @Column(name = "nombre", length = 15)
    private String nombre;

    @Column(name = "material", length = 15)
    private String material;

    @Column(name = "tiempo", length = 15)
    private String tiempo;

//    public Hobbie() {
//    }
//
//    public Hobbie(long hobbyID, String nombre, String material, String tiempo) {
//        this.hobbyID = hobbyID;
//        this.nombre = nombre;
//        this.material = material;
//        this.tiempo = tiempo;
//    }
//
//    public long getHobbyID() {
//        return hobbyID;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getMaterial() {
//        return material;
//    }
//
//    public void setMaterial(String material) {
//        this.material = material;
//    }
//
//    public String getTiempo() {
//        return tiempo;
//    }
//
//    public void setTiempo(String tiempo) {
//        this.tiempo = tiempo;
//    }
}
