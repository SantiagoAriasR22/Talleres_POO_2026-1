package veterinaria;

import java.util.ArrayList;

public class Dueño extends Persona{

    private String id;
    private String correoElectronico;
    private String metodoPago;
    private ArrayList<Animal> mascotas;

    public Dueño(String id, String correoElectronico, String metodoPago, String nombre, String direccion, long telefono) {
        super(nombre, direccion, telefono);
        this.id=id;
        this.correoElectronico=correoElectronico;
        this.metodoPago=metodoPago;
        this.mascotas=new ArrayList<>();
    }

    //getters
    public String getId(){ return id; }
    public String getCorreoElectronico(){ return correoElectronico; }
    public String getMetodoPago(){ return metodoPago; }
    public ArrayList<Animal> getMascotas(){ return mascotas; }

    //setters
    public void setCorreoElectronico(String nuevoCorreoElectronico){ this.correoElectronico=nuevoCorreoElectronico; }
    public void setMetodoPago(String nuevoMetodoPago){ this.metodoPago=nuevoMetodoPago; }
}
