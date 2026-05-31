
package nodos;

import semaforo.Semaforo;
import semaforo.ControlPausaYReinicio;

public class NodoSecundario extends Thread{
    
    private int id;
    private Semaforo semaphore;
    private ControlPausaYReinicio control;
    private Mensaje message;
    private NodoDestino nodoDestino;
    private int velocidadProcesamiento;

    
    public NodoSecundario(ControlPausaYReinicio control, Semaforo semaphore, int id, int velocidadProcesamiento){
        this.control=control;
        this.semaphore=semaphore;
        this.id=id;
        this.nodoDestino= new NodoDestino();
        this.velocidadProcesamiento=velocidadProcesamiento;
    }
    
    @Override
    public void run(){
        try {
            while(!Thread.currentThread().isInterrupted()){
                try {
                    
                    control.verificarEstado(id);
                    message= new Mensaje(id, nodoDestino.getTemperatura(), nodoDestino.getHumedad(), nodoDestino.getLuminiscencia());
                    
                    semaphore.guardarMensaje(message);
                    
                    Thread.sleep(velocidadProcesamiento);
                    
                } catch (RuntimeException e) {
                    System.out.println("Ocurrio un error inesperado "+e);
                }
            }
        } catch (InterruptedException e) {
            
        }
    }
    
    public void setVelocidadProcesamiento(int velocidadProcesamiento){
        this.velocidadProcesamiento=velocidadProcesamiento;
    }
    
}
