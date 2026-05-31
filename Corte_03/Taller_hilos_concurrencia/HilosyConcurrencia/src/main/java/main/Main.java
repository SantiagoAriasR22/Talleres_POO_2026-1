/*ELABORADO POR
-ALEX DAVID FLOREZ CERRO 0222510031
-ANGEL DANIEL MERCHAN VILLAMIZAR 0222510035
-DAVID SANTIAGO ARIAS ROJAS 0222510022*/
package main;

import java.util.ArrayList;
import java.util.Scanner;
import nodos.Mensaje;
import nodos.NodoMaestro;
import nodos.NodoSecundario;
import semaforo.ControlPausaYReinicio;
import semaforo.Semaforo;

public class Main {
    
    private static Scanner sc = new Scanner(System.in);
    private static volatile int nodosSecundarios=0;
    private static volatile int velocidadProcesamiento=0;
    private static ArrayList<Mensaje> mensajesTotales=new ArrayList<>();
    private static ArrayList<NodoSecundario> nodosEnEjecucion=new ArrayList<>();
    private static Semaforo semaphore = new Semaforo();
    static ControlPausaYReinicio control = new ControlPausaYReinicio();
    private static NodoMaestro maestro;
    private static volatile boolean pausado = true;
    private static Pantalla pantalla = new Pantalla();
 
    
    public static void main(String[] args) {
        
        createNodos(); 
        
        java.awt.EventQueue.invokeLater(() -> {
            pantalla.setVisible(true);
        });
    }
    
    public static synchronized void records(){
        
        if(mensajesTotales.isEmpty()){
            System.out.println("Aun no existe ningun registro.");
            return; 
        }
        for(Mensaje message: mensajesTotales){
            
            System.out.println("ID: "+ (message.getId()+1) +" Temperatura: "+message.getTemperatura()+" Humedad: "+message.getHumedad()+"%"+" Luminiscencia: "+message.getLuminiscencia());
        }
        
    }
    
    public static void start(){
        
        if(velocidadProcesamiento==0 || nodosSecundarios==0){
            pantalla.validacionValores("Seleccione la velocidad de procesamiento y la cantidad de nodos secundarios para poder iniciar la simulacion");
            return;
        }
        
        pausado=false;
        pantalla.validacionValores(" ");
        pantalla.actualizarEstadoPrograma("Corriendo simulacion...");
        control.reanudar();
         
    }
    
    public static void pause(){
                    
        pausado=true;
        pantalla.actualizarEstadoPrograma("Simulacion pausada...");
        control.pausar();
    
    }
    
   
    public static void createNodos(){
        
        for(int i=0; i<5; i++){
            NodoSecundario nodoSecundario = new NodoSecundario(control, semaphore, i, velocidadProcesamiento);
            nodoSecundario.start();
            nodosEnEjecucion.add(nodoSecundario);
             
        }
            maestro = new NodoMaestro(control, semaphore, velocidadProcesamiento, pantalla);
            maestro.start();
                  
    }
    public static void killNodos(){
        
        for(NodoSecundario index: nodosEnEjecucion){
            index.interrupt();
        }
        maestro.interrupt();
    }
    
    public static synchronized void restart(){
        pausado=true;
        pantalla.limpiarBotones();
        pantalla.apagarMensajes();
        pantalla.actualizarEstadoPrograma("Esperando por iniciar...");
        killNodos();
        nodosEnEjecucion.clear();
        mensajesTotales.clear(); 
        semaphore.limpiarColaMensajes();
        velocidadProcesamiento=0;
        nodosSecundarios=0;
        createNodos();
    }
    
    public static int nodosSecundariosActivos(){
        return nodosSecundarios;
    }

    public static boolean statusThreads() {
        return pausado; 
    }
    
    public static synchronized void setMensajesTotales(Mensaje message){
        mensajesTotales.add(message);
    }
    public static void setVelocidad(int velocidad){
        velocidadProcesamiento = velocidad;
        
        maestro.setVelocidadProcesamiento(velocidadProcesamiento);
                
        for(NodoSecundario nodo : nodosEnEjecucion){
            nodo.setVelocidadProcesamiento(velocidadProcesamiento);
        }  
    }

    public static void setNodos(int nodos){
        nodosSecundarios = nodos;
        control.notificarNodos();
        pantalla.actualizarNodosVisibles(nodos);
    }
}
