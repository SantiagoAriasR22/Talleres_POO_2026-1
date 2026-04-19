package veterinaria;

import java.util.ArrayList;

public class Veterinario extends Persona{

    private String id;
    private ArrayList<Animal> pacientes;

    public Veterinario(String id, String nombre, String direccion, long telefono) {
        super(nombre, direccion, telefono);
        this.id=id;
        this.pacientes=new ArrayList<>();
    }

    //getters
    public String getId(){ return id; }
    public ArrayList getPacientes(){ return pacientes; }

}
