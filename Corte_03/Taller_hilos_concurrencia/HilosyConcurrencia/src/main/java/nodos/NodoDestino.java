
package nodos;

import java.util.concurrent.ThreadLocalRandom;

public class NodoDestino{
    
    private double temperatura;
    private int humedad;
    private int luminiscencia;
    
    public NodoDestino(){}
    
    public double doGenerarTemperatura(){
        return temperatura=ThreadLocalRandom.current().nextDouble(0, 60);
    }
    
    public double doGenerarHumedad(){
        return humedad=ThreadLocalRandom.current().nextInt(0, 101);
    }
    
    public double doGenerarLuminiscencia(){
        return luminiscencia=ThreadLocalRandom.current().nextInt(0, 1001);
    }
    
    public double getTemperatura(){ return doGenerarTemperatura(); }
    public double getHumedad(){ return doGenerarHumedad(); }
    public double getLuminiscencia(){ return doGenerarLuminiscencia(); }
}
