package Organizador;

public class Rol {

    private long id;
    private String nombre;
    private int nivel;

    public Rol(long id, String nombre, int nivel){
        this.id=id;
        this.nombre=nombre;
        this.nivel=nivel;
    }

    //getters
    public long getId(){ return id; }
    public String getNombre(){ return nombre; }
    public int getNivel(){ return nivel; }

    //setters
    public void setNivel(int nivel){ this.nivel=nivel; }
    public void setNombre(String nombre){ this.nombre=nombre; }
}
