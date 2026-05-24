
package nodos;

import semaforo.Semaforo;
import main.Main; 

public class NodoSecundario extends Thread{
    
    private String id;
    private Semaforo semaphore;
    private Mensaje message;
    private NodoDestino nodoDestino1;
    private NodoDestino nodoDestino2;
    private NodoDestino nodoDestino3;
    private NodoDestino nodoDestino4;
    private NodoDestino nodoDestino5;
    
    public NodoSecundario(Semaforo semaphore, String id){
        this.semaphore=semaphore;
        this.id=id;
        this.nodoDestino1= new NodoDestino();
        this.nodoDestino2= new NodoDestino();
        this.nodoDestino3= new NodoDestino();
        this.nodoDestino4= new NodoDestino();
        this.nodoDestino5= new NodoDestino();
    }
    
    @Override
    public void run(){
        try {
            while(!Thread.currentThread().isInterrupted()){
                try {
                    
                    message= new Mensaje(id, doCalculoPromedioTemperatura(), doCalculoPromedioHumedad(), doCalculoPromedioLuminiscencia());
                    semaphore.guardarMensaje(message);
                    
                    Thread.sleep(800);
                    
                } catch (RuntimeException e) {
                    System.out.println("Ocurrio un error inesperado "+e);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("El hilo finalizo exitosamente "+e);
        }
    }
    
    public double doCalculoPromedioTemperatura(){
        return (nodoDestino1.getTemperatura()+nodoDestino2.getTemperatura()+nodoDestino3.getTemperatura()+nodoDestino4.getTemperatura()+nodoDestino5.getTemperatura())/5;
    }
    
    public double doCalculoPromedioHumedad(){
        return (nodoDestino1.getHumedad()+nodoDestino2.getHumedad()+nodoDestino3.getHumedad()+nodoDestino4.getHumedad()+nodoDestino5.getHumedad())/5;
    }
    
    public double doCalculoPromedioLuminiscencia(){
        return (nodoDestino1.getLuminiscencia()+nodoDestino2.getLuminiscencia()+nodoDestino3.getLuminiscencia()+nodoDestino4.getLuminiscencia()+nodoDestino5.getLuminiscencia())/5;
    }
    
}
