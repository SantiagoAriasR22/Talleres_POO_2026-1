package veterinaria;

import java.util.ArrayList;

public class Veterinario extends Persona{

    private String numeroLicencia;
    private String especialidad;
    private int añosExperiencia;
    private ArrayList<Animal> pacientes;

    public Veterinario(String numeroLicencia, String especialidad, int añosExperiencia, String nombre, String direccion, long telefono) {
        super(nombre, direccion, telefono);
        this.numeroLicencia =numeroLicencia;
        this.especialidad=especialidad;
        this.añosExperiencia=añosExperiencia;
        this.pacientes=new ArrayList<>();
    }

    //getters
    public String getNumeroLicencia(){ return numeroLicencia; }
    public ArrayList<Animal> getPacientes(){ return pacientes; }
    public String getEspecialidad(){ return especialidad; }
    public int getAñosExperiencia(){ return añosExperiencia; }

    //setters
    public void setEspecialidad(String nuevaEspecialidad){ this.especialidad=nuevaEspecialidad; }
    public void setAñosExperiencia(int nuevosAñosExperiencia){ this.añosExperiencia=nuevosAñosExperiencia; }
    public void setAgregarPaciente(Animal animal)
    {
        if(!pacientes.contains(animal)){
            pacientes.add(animal);
        }
        else{
        System.out.println("El animal ya existia en el sistema");
        return;}
    }
}
