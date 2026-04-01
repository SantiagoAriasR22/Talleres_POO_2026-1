package Organizador;

import java.util.ArrayList;

public class Oficina {

    private long id;
    private String nombre;
    private ArrayList<Empleado> empleados;
    private ArrayList<Tarea> tareas;

    public Oficina(long id, String nombre){
        this.id=id;
        this.nombre=nombre;
        this.empleados=new ArrayList<>();
        this.tareas=new ArrayList<>();
    }

    //getters
    public long getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    //setters
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    //methods
    public void agregarEmpleado(Empleado empleado){
        if(empleado != null && !this.empleados.contains(empleado)){
            this.empleados.add(empleado);
        }
    }

    public void eliminarEmpleado(Empleado empleado){
        this.empleados.remove(empleado);
    }

    public void crearTarea(long id, String descripcion){
        Tarea nuevaTarea = new Tarea(id, descripcion, "en desarrollo");
        this.tareas.add(nuevaTarea);
    }

    public void finalizarTarea(long idTarea){

        for(Tarea i: tareas){
            if(i.getId()==idTarea){
                i.setEstado("finalizada");
                break;
            }
        }
    }

}
