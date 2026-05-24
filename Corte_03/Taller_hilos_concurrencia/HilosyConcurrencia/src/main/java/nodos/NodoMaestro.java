
package nodos;

import java.util.ArrayList;
import semaforo.Semaforo;
import main.Main; 

public class NodoMaestro extends Thread{
    
    private Semaforo semaphore;
    private static ArrayList<Mensaje> mensajesProcesados = new ArrayList<>();
    private String estado="Disponible";
    private int velocidadProcesamiento;
    
    public NodoMaestro(Semaforo semaphore, int velocidadProcesamiento){
        this.semaphore=semaphore;
        this.velocidadProcesamiento=velocidadProcesamiento;
    }
    public void setVelocidadProcesamiento(int velocidad){
        this.velocidadProcesamiento=velocidad; 
    }
    
    @Override
    public void run(){
        try {
            while(!Thread.currentThread().isInterrupted()){
                try {
                    synchronized (this) {
                    while (Main.statusThreads()) 
                        {   
                        this.wait(); 
                        }
    }
                    
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
    public static void clearMessage(){
        mensajesProcesados.clear(); 
    }
    
}
