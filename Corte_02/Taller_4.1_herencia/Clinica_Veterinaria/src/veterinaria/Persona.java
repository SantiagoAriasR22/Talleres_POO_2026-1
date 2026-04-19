package veterinaria;

public class Persona {

    private String nombre;
    private String direccion;
    private long telefono;

    public Persona(String nombre, String direccion, long telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    //getters
    public String getNombre() { return nombre; }
    public String getDireccion() { return direccion; }
    public long getTelefono() { return telefono; }

    //setters
    public void setDireccion(String nuevaDireccion){ this.direccion=nuevaDireccion; }
    public void setTelefono(long nuevoTelefono){ this.telefono=nuevoTelefono; }

}
