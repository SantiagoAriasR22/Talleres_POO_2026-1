package veterinaria;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; // Para darle un formato bonito

public class Tratamiento {

    private String id;
    private String nombreDelTratamiento;
    private String descripcionDelTratamiento;
    private String fechaTratamiento;

    public Tratamiento(String id, String nombreDelTratamiento, String descripcionDelTratamiento){
        this.id=id;
        this.nombreDelTratamiento=nombreDelTratamiento;
        this.descripcionDelTratamiento=descripcionDelTratamiento;

        LocalDateTime actual=LocalDateTime.now();
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.fechaTratamiento=actual.format(formato);
    }

    //getters
    public String getId(){ return id; }
    public String getNombreDelTratamiento(){ return nombreDelTratamiento; }
    public String getDescripcionDelTratamiento(){ return descripcionDelTratamiento; }
    public String getFechaTratamiento(){ return fechaTratamiento; }

    //setters
    public void setNombreDelTratamiento(String nuevoNombreDelTratamiento){ this.nombreDelTratamiento=nuevoNombreDelTratamiento; }
    public void setDescripcionDelTratamiento(String nuevaDescripcionDelTratamiento){ this.descripcionDelTratamiento=nuevaDescripcionDelTratamiento; }
}
