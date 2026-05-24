
package nodos;

import java.util.ArrayList;
import semaforo.Semaforo;

public class NodoMaestro extends Thread{
    
    private Semaforo semaphore;
    private ArrayList<Mensaje> mensajesProcesados = new ArrayList<>();
    private String estado="Disponible";
    private int velocidadProcesamiento;
    
    public NodoMaestro(Semaforo semaphore, int velocidadProcesamiento){
        this.semaphore=semaphore;
        this.velocidadProcesamiento=velocidadProcesamiento;
    }
    
    @Override
    public void run(){
        try {
            while(!Thread.currentThread().isInterrupted()){
                try {
                    
                    Mensaje mensajeProcesado=semaphore.retirarMensaje();
                    
                    if(mensajeProcesado!=null){
                        //System.out.println("Ocupado");
                        Thread.sleep(velocidadProcesamiento);
                        mensajesProcesados.add(mensajeProcesado);
                        
                        //System.out.println("Disponible");
                    }
                    
                    
                } catch (RuntimeException e) {
                    System.out.println("Ocurrio un error inesperado "+e);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("El hilo finalizo exitosamente "+e);
        }
    }
    
    public ArrayList<Mensaje> getMensajesProcesados(){
        return mensajesProcesados;
    }
    
}
