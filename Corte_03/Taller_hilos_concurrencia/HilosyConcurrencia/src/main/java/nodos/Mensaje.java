
package nodos;

public class Mensaje {
    
    private int id;
    private double temperatura;
    private double humedad;
    private double luminiscencia;
    
    public Mensaje(int id, double temperatura, double humedad, double luminiscencia){
        this.id=id;
        this.temperatura=temperatura;
        this.humedad=humedad;
        this.luminiscencia=luminiscencia;
    }
    
    public int getId(){ return id; }
    public double getTemperatura(){ return temperatura; }
    public double getHumedad(){ return humedad; }
    public double getLuminiscencia(){ return luminiscencia; }
    
}
