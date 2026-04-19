package veterinaria;

import java.util.ArrayList;

public class HistoriaClinica {

    private String id;
    private ArrayList<Tratamiento> tratamientos;
    private ArrayList<Dueño> dueños;
    private Animal animal;

    HistoriaClinica(String id, Animal animal){
        this.id=id;
        this.animal=animal;
        this.tratamientos=new ArrayList<>();
        this.dueños=new ArrayList<>();
    }

    //getters
    public String getId(){ return id; }
    public ArrayList<Tratamiento> getTratamientos(){ return tratamientos; }
    public ArrayList<Dueño> getDueños(){ return dueños; }
    public Animal getAnimal(){ return animal; }

    //methods
    public void doAgregarDueño(Dueño nuevoDueño){ dueños.add(nuevoDueño); }
}
