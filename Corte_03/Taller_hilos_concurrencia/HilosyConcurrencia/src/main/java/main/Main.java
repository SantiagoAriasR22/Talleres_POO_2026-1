/*ELABORADO POR
-ALEX DAVID FLOREZ CERRO 0222510031
-ANGEL DANIEL MERCHAN VILLAMIZAR 0222510035
-DAVID SANTIAGO ARIAS ROJAS 0222510022*/
package main;
//cantidad mensaje por nodo
//total de mensajes procesados
//cantidad de reinicios
//nodos activados 
//cant reinicios
//promedio temp, lum, hum
//tiempo ejecucion
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
    private static ControlPausaYReinicio control = new ControlPausaYReinicio();
    private static NodoMaestro maestro;
    private static volatile boolean pausado = true;
    private static Pantalla pantalla = new Pantalla();
    private static int mensajesN1=0;
    private static int mensajesN2=0;
    private static int mensajesN3=0;
    private static int mensajesN4=0;
    private static int mensajesN5=0;
    private static double totLumniscencia=0;
    private static double totTemperatura=0;
    private static double totHumedad=0;
    private static int cantReinicios=0;
    private static long tiempoInicial=System.nanoTime();
    private static long tiempoFinal;
    private static int totalMensajes=0;
    
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
            mensajesN1=0;
            mensajesN2=0;
            mensajesN3=0;
            mensajesN4=0;
            mensajesN5=0;
            totHumedad=0;
            totHumedad=0;
            totLumniscencia=0;
            totTemperatura=0; 
        for(Mensaje message: mensajesTotales){
            
            System.out.println("ID: "+ (message.getId()+1) +" Temperatura: "+message.getTemperatura()+" Humedad: "+message.getHumedad()+"%"+" Luminiscencia: "+message.getLuminiscencia());
            
            totLumniscencia+=message.getLuminiscencia();
            totHumedad+=message.getHumedad();
            totTemperatura+=message.getTemperatura();
            switch(message.getId()){
                case 0: mensajesN1++;  break;
                case 1: mensajesN2++; break;
                case 2: mensajesN3++; break;
                case 3: mensajesN4++; break;
                case 4: mensajesN5++; break;
            }
        }
            totalMensajes=mensajesTotales.size();
            System.out.println("==========Stats==========");
            System.out.println("Cantidad de menasajes enviados por cada nodo ");
            System.out.println("Nodo 1 "+mensajesN1);
            System.out.println("Nodo 2 "+mensajesN2);
            System.out.println("Nodo 3 "+mensajesN3);
            System.out.println("Nodo 4 "+mensajesN4);
            System.out.println("Nodo 5 "+mensajesN5);
            System.out.println("Total de mensajes enviados "+totalMensajes);
            System.out.println("Promedios de ");
            System.out.println("Temperatura "+totTemperatura/totalMensajes);
            System.out.println("Humedad "+totHumedad/totalMensajes);
            System.out.println("Luminiscencia "+totLumniscencia/totalMensajes);
            tiempoFinal=System.nanoTime();
            System.out.println("Tiempo de ejecucion "+ (tiempoFinal-tiempoInicial)/1000.0+"s");
        

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
        totalMensajes+=mensajesTotales.size();
        pantalla.apagarMensajes();
        pantalla.limpiarBotones();
        pantalla.estadoVelocidad("Velocidad de procesamiento: 0ms");
        pantalla.actualizarEstadoPrograma("Esperando por iniciar...");
        killNodos();
        nodosEnEjecucion.clear();
        mensajesTotales.clear(); 
        semaphore.limpiarColaMensajes();
        velocidadProcesamiento=0;
        nodosSecundarios=0;
        cantReinicios++;
        mensajesN1=0;
        mensajesN2=0;
        mensajesN3=0;
        mensajesN4=0;
        mensajesN5=0;
        totLumniscencia=0;
        totTemperatura=0;
        totHumedad=0;
        totalMensajes=0;
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
        
        if(maestro!=null){
            maestro.setVelocidadProcesamiento(velocidadProcesamiento);
        }
                
        for(NodoSecundario nodo : nodosEnEjecucion){
            nodo.setVelocidadProcesamiento(velocidadProcesamiento);
        }  
    }

    public static void setNodos(int nodos){
        nodosSecundarios = nodos;
        control.notificarNodos();
        pantalla.actualizarNodosVisibles(nodos);
    }
    //getters
    public static int getTotalMensajes() { return totalMensajes; }
    public static long getTiempoInicial() { return tiempoInicial; }
    public static int getMensajesN1() { return mensajesN1; }
    public static int getMensajesN2() { return mensajesN2; }
    public static int getMensajesN3() { return mensajesN3; }
    public static int getMensajesN4() { return mensajesN4; }
    public static int getMensajesN5() { return mensajesN5; }
    public static double getTotTemperatura() { return totTemperatura; }
    public static double getTotHumedad() { return totHumedad; }
    public static double getTotLumniscencia() { return totLumniscencia; }
    public static int getCantReinicios() { return cantReinicios; }
}
