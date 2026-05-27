
package nodos;

import semaforo.Semaforo;
import semaforo.ControlPausaYReinicio;
import main.Main;

public class NodoMaestro extends Thread{
    
    private ControlPausaYReinicio control;
    private Semaforo semaphore;
    private String estado="Disponible";
    private int velocidadProcesamiento;
    private Mensaje mensajeProcesado;
    
    public NodoMaestro(ControlPausaYReinicio control, Semaforo semaphore, int velocidadProcesamiento){
        this.control=control;
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
                    
                    control.verificarEstado(1);
                    mensajeProcesado=semaphore.retirarMensaje();
                    
                    if(mensajeProcesado!=null){
                        //System.out.println("Ocupado");
                        Thread.sleep(velocidadProcesamiento);
                        Main.setMensajesTotales(mensajeProcesado);
                        
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
    
}
