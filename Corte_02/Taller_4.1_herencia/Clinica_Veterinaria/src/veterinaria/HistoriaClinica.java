package veterinaria;

import java.util.ArrayList;

public class HistoriaClinica {

    private String id;
    private ArrayList<Tratamiento> tratamientos;
    private ArrayList<Dueño> dueños;
    private Animal animal;

    public HistoriaClinica(String id, Animal animal){
        this.id=id;
        this.animal=animal;
        this.tratamientos=new ArrayList<>();
        this.dueños=new ArrayList<>();
    }

    //getters
    public String getId(){ return id; }
    public ArrayList getTratamientos(){ return tratamientos; }
    public ArrayList getDueños(){ return dueños; }
    public Animal getAnimal(){ return animal; }


}
