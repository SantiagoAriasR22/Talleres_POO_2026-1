package Organizador;

import java.util.ArrayList;

public class Oficina {

    private String id;
    private String nombre;
    private ArrayList<Empleado> empleados;
    private ArrayList<Tarea> tareas;

    public Oficina(String id, String nombre){
        this.id=id;
        this.nombre=nombre;
        this.empleados=new ArrayList<>();
        this.tareas=new ArrayList<>();
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


    //methods
    public void agregarEmpleado(Empleado empleado){
        if(empleado != null && !this.empleados.contains(empleado)){
            this.empleados.add(empleado);
        }
    }

    public void eliminarEmpleado(Empleado empleado){
        this.empleados.remove(empleado);
    }

    public Tarea registrarTareaPropia(String id, String idOficinaCreadora, String descripcion){
        Tarea tarea=new Tarea(id, idOficinaCreadora, descripcion, "En desarrollo");
        this.tareas.add(tarea);
        return tarea;
    }

    public void vincularTareaDeOtraOficina(Tarea tarea){
        if(!tareas.contains(tarea)){
            tareas.add(tarea);
            System.out.println("Ya se agrego la tarea con exito a la oficina "+id);
        }
        else{ System.out.println("La tarea que se quiere registrar ya esta asignada a esta oficina"); }
    }

    public void finalizarTarea(String idTarea){

        for(Tarea i: tareas){
            if(idTarea.equals(i.getId())){
                i.setEstado("Finalizada");
                break;
            }
        }
    }

    public void eliminarTarea(Tarea tarea){ tareas.remove(tarea);}

}
