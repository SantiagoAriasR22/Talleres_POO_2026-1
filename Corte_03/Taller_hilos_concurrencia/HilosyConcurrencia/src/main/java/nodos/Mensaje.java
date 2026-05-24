
package nodos;

public class Mensaje {
    
    private String id;
    private double temperatura;
    private double humedad;
    private double luminiscencia;
    
    public Mensaje(String id, double temperatura, double humedad, double luminiscencia){
        this.id=id;
        this.temperatura=temperatura;
        this.humedad=humedad;
        this.luminiscencia=luminiscencia;
    }
    
    public String getId(){ return id; }
    public double getTemperatura(){ return temperatura; }
    public double getHumedad(){ return humedad; }
    public double getLuminiscencia(){ return luminiscencia; }
    
}
