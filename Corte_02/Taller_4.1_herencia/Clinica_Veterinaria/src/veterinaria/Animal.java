package veterinaria;

import java.util.ArrayList;

public class Animal {

    private String nombre;
    private String raza;
    private String tamaño;
    private String especie;
    private Dueño dueño;

    public Animal(String nombre, Dueño dueño, String raza, String tamaño, String especie){
        this.nombre=nombre;
        this.dueño=dueño;
        this.raza=raza;
        this.tamaño=tamaño;
        this.especie=especie;
    }

    //getters
    public String getNombre(){ return nombre; }
    public Dueño getDueño(){ return dueño; }

}
