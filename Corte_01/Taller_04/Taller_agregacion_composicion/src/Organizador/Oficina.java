package Organizador;

import java.util.ArrayList;

public class Oficina {

    private String id;
    private String nombre;
    private ArrayList<Empleado> empleados;
    private ArrayList<Tarea> tareas;

    public Oficina(String id, String nombre, String idTareaInicial, String descripcionTareaInicial){
        this.id=id;
        this.nombre=nombre;
        this.empleados=new ArrayList<>();
        this.tareas=new ArrayList<>();
        this.registrarTarea(idTareaInicial, descripcionTareaInicial);
    }

    //getters
    public String getId(){
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

    public void registrarTarea(String id, String descripcion){
        this.tareas.add(new Tarea(id, descripcion, "en desarrollo"));
    }

    public void finalizarTarea(String idTarea){

        for(Tarea i: tareas){
            if(idTarea.equals(i.getId())){
                i.setEstado("finalizada");
                break;
            }
        }
    }

}
