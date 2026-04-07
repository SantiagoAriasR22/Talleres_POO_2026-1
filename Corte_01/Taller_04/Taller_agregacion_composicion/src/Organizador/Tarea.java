package Organizador;

import java.util.ArrayList;

public class Tarea {

    private String id;
    private String idOficinaCreadora;
    private String descripcion;
    private String estado;
    private ArrayList<Oficina> oficinasColaboradoras;

    public Tarea(String id, String idOficinaCreadora, String descripcion, String estado){
        this.id=id;
        this.idOficinaCreadora=idOficinaCreadora;
        this.descripcion=descripcion;
        this.estado=estado;
        this.oficinasColaboradoras= new ArrayList<>();
    }

    //getters
    public String getId(){ return id; }
    public String getEstado(){
        return estado;
    }
    public String getDescripcion(){ return descripcion; }
    public ArrayList<Oficina> getOficinasColaboradoras(){ return oficinasColaboradoras; }
    public String getIdOficinaCreadora(){ return idOficinaCreadora; }

    //setters
    public void setEstado(String estado){ this.estado=estado; }

    //methods
    public void agregarColaborador(Oficina oficina){
        oficinasColaboradoras.add(oficina);
    }

}
