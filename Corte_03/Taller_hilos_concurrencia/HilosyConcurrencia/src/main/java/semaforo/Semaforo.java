package semaforo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import main.Main;
import nodos.Mensaje;

public class Semaforo {
    
    private int cantidadNodosSecundarios=5;
    private Queue<Mensaje>[] colasEspera;
    private int turno=0;
    private Semaphore semaphoreNodoMaestro = new Semaphore(0); //se encarga de avisarle al nodo maestro que hay mensajes en cola
    private Semaphore semaphoreMensajes = new Semaphore(1); //Evita que dos hilos intenten guardar un mensaje en la misma celda
    private Semaphore[] semaphoreColaEspera; //lleva el conteo de cuantos espacios libre hay en cada cola de espera
    
    public Semaforo(){
        colasEspera= new LinkedList[cantidadNodosSecundarios];
        semaphoreColaEspera=new Semaphore[cantidadNodosSecundarios];
        for(int i=0; i<cantidadNodosSecundarios; i++){
            colasEspera[i]=new LinkedList<>();
            semaphoreColaEspera[i]=new Semaphore(5); //cada lista tiene 5 espacios
        }
    }
        
    public void guardarMensaje(Mensaje message){
            
        try {
            
            if(Main.statusThreads()){ 
                return; 
            }
            
            int idNodoSecundario=message.getId(); //se obtiene la id del nodo secundario que envio el mensaje, para saber en que lista enlazada ponerlo
            semaphoreColaEspera[idNodoSecundario].acquire(); //primero verifica si hay espacio en su cola de espera a traves del semaforo si es mayor a 1 lo deja pasar, si no se duerme
            semaphoreMensajes.acquire(); //ahora verifica si no hay otro hilo modificando la cola, si es 1 no hay nadie y es libre de modificarlo, si es 0 le toca esperar
            colasEspera[idNodoSecundario].add(message);//agregue el mensaje a la lista enlazada que le corresponde segun el id que lleva
            
            semaphoreNodoMaestro.release(); //avisa al nodo maestro de que hay mensajes en cola
            semaphoreMensajes.release(); //cambia el valor del semaforo para que el hilo que este esperando pueda agregar su mensaje a la cola
            
        } catch (InterruptedException e) {
            System.out.println("Reiniciando la cola de espera..."+e);
        }
    }
    
    public Mensaje retirarMensaje(){
        
        Mensaje message=null;
        
        try {
            semaphoreNodoMaestro.acquire(); //el hilo maestro verifica si hay mensajes en cola, si es 1 procesa el mensaje, si es 0 se duerme
            semaphoreMensajes.acquire(); //ahora verifica si no hay otro hilo modificando la cola de espera, si es 1 no hay nadie y es libre de modificarlo, si es 0 le toca esperar
            
            while(message==null){ //sirve para evitar que el nodoMaestro se lleve un mensaje vacio
                if(!colasEspera[turno].isEmpty()){ 
                    message=colasEspera[turno].poll(); //quita el primer mensaje que hay en cola y lo asigna a una variable
                    semaphoreColaEspera[turno].release(); //como ya se proceso un mensaje, en la cola se libera un espacio
                }
                turno=(turno+1)%cantidadNodosSecundarios;
            }
            
            semaphoreMensajes.release(); //cambia el valor del semaforo para que el hilo que esta esperando pueda modificar el arreglo
            
        } catch (InterruptedException e) {
            System.out.println("Ocurrio un error inesperado "+e);
        }
        
        return message;
    }
    
    public void limpiarColaMensajes(){
        
        boolean permisoAdquirido=false;
        
        try {
            semaphoreMensajes.acquire();
            permisoAdquirido=true;
            
            for(int i=0; i<cantidadNodosSecundarios; i++){
                colasEspera[i].clear();
                semaphoreColaEspera[i].drainPermits();  
                semaphoreColaEspera[i].release(5);
            }
            turno=0;
            semaphoreNodoMaestro.drainPermits(); 
            
        } catch (Exception e) {
            System.out.println("Error al reiniciar la cola "+e);
        } finally {    
            if(permisoAdquirido) semaphoreMensajes.release();
        }
    }
        
}
