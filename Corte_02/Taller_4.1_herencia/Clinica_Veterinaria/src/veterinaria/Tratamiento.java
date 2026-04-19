package veterinaria;

public class Tratamiento {

    private String id;
    private String nombreDelTratamiento;
    private String descripcionDelTratamiento;

    public Tratamiento(String id, String nombreDelTratamiento, String descripcionDelTratamiento){
        this.id=id;
        this.nombreDelTratamiento=nombreDelTratamiento;
        this.descripcionDelTratamiento=descripcionDelTratamiento;
    }

    //getters
    public String getId(){ return id; }
    public String getNombreDelTratamiento(){ return nombreDelTratamiento; }
    public String getDescripcionDelTratamiento(){ return descripcionDelTratamiento; }

    //setters
    public void setNombreDelTratamiento(String nuevoNombreDelTratamiento){ this.nombreDelTratamiento=nuevoNombreDelTratamiento; }
    public void setDescripcionDelTratamiento(String nuevaDescripcionDelTratamiento){ this.descripcionDelTratamiento=nuevaDescripcionDelTratamiento; }
}
