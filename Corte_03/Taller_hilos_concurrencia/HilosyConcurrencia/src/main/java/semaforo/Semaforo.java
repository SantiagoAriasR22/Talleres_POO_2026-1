package semaforo;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import nodos.Mensaje;

public class Semaforo {
    
    private static ArrayList<Mensaje> colaEspera = new ArrayList<>();
    private Semaphore semaphoreNodoMaestro = new Semaphore(0); //se encarga de avisarle al nodo maestro que hay mensajes en cola
    private Semaphore semaphoreMensajes = new Semaphore(1); //Evita que dos hilos intenten guardar un mensaje en la misma celda
    private Semaphore semaphoreColaEspera = new Semaphore(1000); //lleva el conteo de cuantos espacios libre hay en la cola de espera
        
    public void guardarMensaje(Mensaje message){
            
        try {
            semaphoreColaEspera.acquire(); //primero verifica si hay espacio en el array list a traves del semaforo si es mayor a 1 lo deja pasar, si no se duerme
            semaphoreMensajes.acquire(); //ahora verifica si no hay otro hilo modificando el arraylist, si es 1 no hay nadie y es libre de modificarlo, si es 0 le toca esperar
            colaEspera.add(message); //agregue el mensaje al arraylist
            
            semaphoreNodoMaestro.release(); //avisa al nodo maestro de que hay mensajes en cola
            semaphoreMensajes.release(); //cambia el valor del semaforo para que el hilo que este esperando pueda agregar su mensaje a la cola
        } catch (InterruptedException e) {
            System.out.println("Ocurrio un error inesperado "+e);
        }
    }
    
    public Mensaje retirarMensaje(){
        
        Mensaje message=null;
        
        try {
            semaphoreNodoMaestro.acquire(); //el hilo maestro verifica si hay mensajes en cola, si es 1 procesa el mensaje, si es 0 se duerme
            semaphoreMensajes.acquire(); //ahora verifica si no hay otro hilo modificando el arraylist, si es 1 no hay nadie y es libre de modificarlo, si es 0 le toca esperar
            message=colaEspera.remove(0); //quita el primer mensaje que hay en cola y lo asigna a una variable
            semaphoreMensajes.release(); //cambia el valor del semaforo para que el hilo que esta esperando pueda modificar el arreglo
            semaphoreColaEspera.release(); //como ya se proceso un mensaje, en la cola se libera un espacio
            
        } catch (InterruptedException e) {
            System.out.println("Ocurrio un error inesperado "+e);
        }
        
        return message;
    }
    public static void clearTail(){
        colaEspera.clear();
    }
        
}
