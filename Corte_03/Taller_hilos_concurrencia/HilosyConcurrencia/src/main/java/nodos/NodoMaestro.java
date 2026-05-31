
package nodos;

import semaforo.Semaforo;
import semaforo.ControlPausaYReinicio;
import main.Main;
import main.Pantalla;

public class NodoMaestro extends Thread{
    
    private ControlPausaYReinicio control;
    private Semaforo semaphore;
    private int velocidadProcesamiento;
    private Mensaje mensajeProcesado;
    private Pantalla pantalla;
    
    public NodoMaestro(ControlPausaYReinicio control, Semaforo semaphore, int velocidadProcesamiento, Pantalla pantalla){
        this.control=control;
        this.semaphore=semaphore;
        this.velocidadProcesamiento=velocidadProcesamiento;
        this.pantalla=pantalla;
    }
    
    public void setVelocidadProcesamiento(int velocidad){
        this.velocidadProcesamiento=velocidad; 
    }
    
    @Override
    public void run(){
        try {
            
            if(pantalla!=null){
                pantalla.actualizarEstadoMaestro("Disponible");
            }
            
            while(!Thread.currentThread().isInterrupted()){
                try {
                    
                    control.verificarEstado(0);
                    mensajeProcesado=semaphore.retirarMensaje();
                    
                    if(mensajeProcesado!=null){
                        int idNodo = mensajeProcesado.getId();
                        
                            
                        if(idNodo<Main.nodosSecundariosActivos()){
                            pantalla.actualizarEstadoMaestro("Ocupado");
                                
                            if(pantalla != null) {
                                pantalla.iluminarMensaje(idNodo);
                            }
                            
                            Thread.sleep(velocidadProcesamiento);

                            if(pantalla != null) {
                                pantalla.apagarMensaje(idNodo);
                                pantalla.actualizarEstadoMaestro("Disponible");
                            }
                        
                                Main.setMensajesTotales(mensajeProcesado);
                        }
                        
                    }
                    
                    
                } catch (RuntimeException e) {
                    System.out.println("Ocurrio un error inesperado "+e);
                }
            }
        } catch (InterruptedException e) {
            
        }
    }
    
}
