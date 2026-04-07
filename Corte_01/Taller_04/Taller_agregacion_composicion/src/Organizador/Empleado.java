package Organizador;

import java.util.ArrayList;

public class Empleado {

    private String id;
    private String nombre;
    private Rol rol;
    private ArrayList<Oficina> oficinas;

    public Empleado(String id, String nombre, Rol rol){
        this.id=id;
        this.nombre=nombre;
        this.rol=rol;
        this.oficinas=new ArrayList<>();
    }

    //getters
    public String getId(){
        return id;
    }

    public String getNombre(){return nombre; }

    public Rol getRol(){
        return rol;
    }

    public ArrayList<Oficina> getOficinas(){ return oficinas; }

    //methods
    public void eliminarOficina(Oficina oficina){
        this.oficinas.remove(oficina);
    }

    public void agregarOficina(Oficina oficina){
        if(oficina != null && !this.oficinas.contains(oficina)){
            this.oficinas.add(oficina);
        }
    }

}
