package veterinaria;

public class Animal {

    private String id;
    private String nombre;
    private String raza;
    private String tamaño;
    private String especie;
    private Dueño dueño;
    private HistoriaClinica historiaClinica;

    public Animal(String id, String nombre, String raza, String tamaño, String especie){
        this.id=id;
        this.nombre=nombre;
        this.raza=raza;
        this.dueño=null;
        this.tamaño=tamaño;
        this.especie=especie;
        this.historiaClinica=new HistoriaClinica("H"+id, this);
    }

    //getters
    public String getNombre(){ return nombre; }
    public Dueño getDueño(){ return dueño; }
    public String getId(){ return id; }
    public String getRaza(){ return raza; }
    public String getTamaño(){ return tamaño; }
    public HistoriaClinica getHistoriaClinica(){ return historiaClinica; }
    public String getEspecie(){ return especie; }

    //setters
    public void setNombre(String nuevoNombre){ this.nombre=nuevoNombre; }
    public void setDueño(Dueño nuevoDueño){ this.dueño=nuevoDueño; }

    //methods
    public void doEliminarDueño(){ this.dueño=null; }
}
