
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
    
    public int doGenerarHumedad(){
        return humedad=ThreadLocalRandom.current().nextInt(0, 101);
    }
    
    public int doGenerarLuminiscencia(){
        return luminiscencia=ThreadLocalRandom.current().nextInt(0, 1001);
    }
    
    public double getTemperatura(){ return doGenerarTemperatura(); }
    public int getHumedad(){ return doGenerarHumedad(); }
    public int getLuminiscencia(){ return doGenerarLuminiscencia(); }
}
