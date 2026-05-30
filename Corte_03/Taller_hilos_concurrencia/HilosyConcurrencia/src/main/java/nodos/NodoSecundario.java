
package nodos;

import semaforo.Semaforo;
import semaforo.ControlPausaYReinicio;

public class NodoSecundario extends Thread{
    
    private int id;
    private String idNodo;
    private Semaforo semaphore;
    private ControlPausaYReinicio control;
    private Mensaje message;
    private NodoDestino nodoDestino;

    
    public NodoSecundario(ControlPausaYReinicio control, Semaforo semaphore, String idNodo, int id){
        this.control=control;
        this.semaphore=semaphore;
        this.idNodo=idNodo;
        this.id=id;
        this.nodoDestino= new NodoDestino();

    }
    
    @Override
    public void run(){
        try {
            while(!Thread.currentThread().isInterrupted()){
                try {
                    
                    control.verificarEstado(id);
                    message= new Mensaje(idNodo, nodoDestino.getTemperatura(), nodoDestino.getHumedad(), nodoDestino.getLuminiscencia());
                    
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
    
}
