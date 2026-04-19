package veterinaria;

import java.util.ArrayList;

public class Dueño extends Persona{

    String id;
    ArrayList<Animal> mascotas;

    public Dueño(String id, String nombre, String direccion, long telefono) {
        super(nombre, direccion, telefono);
        this.id=id;
        this.mascotas=new ArrayList<>();
    }

    //getters
    public String getId(){ return id; }
    public ArrayList getMascotas(){ return mascotas; }
}
