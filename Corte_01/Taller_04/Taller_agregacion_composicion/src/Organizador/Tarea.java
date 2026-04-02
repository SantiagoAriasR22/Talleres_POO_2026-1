package Organizador;

public class Tarea {

    private String id;
    private String descripcion;
    private String estado;

    public Tarea(String id, String descripcion, String estado){
        this.id=id;
        this.descripcion=descripcion;
        this.estado=estado;
    }

    //getters
    public String getId(){ return id; }
    public String getEstado(){
        return estado;
    }
    public String getDescripcion(){ return descripcion; }

    //setters
    public void setDescripcion(String descripcion){
        if(this.estado.equals("finalizada")){
            System.out.println("No se puede cambiar la descripcion de una tarea ya finalizada");
        }
        else{
            this.descripcion=descripcion;
        }
    }

    public void setEstado(String estado){ this.estado=estado; }
}
