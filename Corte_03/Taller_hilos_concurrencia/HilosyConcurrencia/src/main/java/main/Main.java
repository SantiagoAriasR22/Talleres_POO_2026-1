
package main;

import java.util.ArrayList;
import java.util.Scanner;
import nodos.Mensaje;
import nodos.NodoMaestro;
import nodos.NodoSecundario;
import semaforo.Semaforo;

public class Main {
    
    private static Scanner sc = new Scanner(System.in);
    private static int nodosSecundarios=0;
    private static int velocidadProcesamiento=0;
    private static ArrayList<Mensaje> mensajesTotales=new ArrayList<>();
    private static ArrayList<NodoSecundario> nodosEnEjecucion=new ArrayList<>();
    private static Semaforo semaphore = new Semaforo();
    private static NodoMaestro maestro;
    private static volatile boolean pausado = false;
    
    public static void main(String[] args) {
        
        int opcion;
        
        do {            
            opcion=menu();
            
            switch (opcion) {
                case 1: emulator(); break;
                case 2: options(); break;
                case 3: SecondaryNode(); break;
                case 4: records(); break;
            }
        } while (opcion!=5);
        
    }
    
    public static int menu(){
        
        int opcion=0;
        
        System.out.println("1. Emulator");
        System.out.println("2. Options");
        System.out.println("3. Secondary Node");
        System.out.println("4. Records");
        System.out.println("5. Salir");
        
        System.out.println("Escoja una opcion: ");
        opcion=sc.nextInt();
        
        return opcion;
    }
    
    public static void emulator(){
        
        int opcion;
        
        do{
            System.out.println("1. Start");
            System.out.println("2. Pause");
            System.out.println("3. Restart");
            System.out.println("4. Close");
            
            System.out.println("Escoja una opcion: ");
            opcion=sc.nextInt();
            
            switch(opcion){
                case 1: start();break;
                case 2: pause();break;
                case 3: restart();break;
            }
        }while(opcion!=4);
    }
    
    public static void options(){
        
        int opcion;
        
        do{
     
            System.out.println("1. Very Slow");
            System.out.println("2. Slow");
            System.out.println("3. Fast");
            System.out.println("4. Very Fast");
            System.out.println("5. Salir");
            
            System.out.println("Escoja una opcion: ");
            opcion=sc.nextInt();
            
            switch(opcion){
                case 1: velocidadProcesamiento=3500; break;
                case 2: velocidadProcesamiento=2500; break;
                case 3: velocidadProcesamiento=1500; break;
                case 4: velocidadProcesamiento=1000; break;
            }
            
        }while(opcion!=5);
    }
    
    public static void SecondaryNode(){
        
        int opcion;
        
        do{
     
            System.out.println("1. One");
            System.out.println("2. Two");
            System.out.println("3. Three");
            System.out.println("4. Four");
            System.out.println("5. Five");
            System.out.println("6. Salir");
            
            System.out.println("Escoja una opcion: ");
            opcion=sc.nextInt();
            
            switch(opcion){
                case 1: nodosSecundarios=1; break;
                case 2: nodosSecundarios=2; break;
                case 3: nodosSecundarios=3; break;
                case 4: nodosSecundarios=4; break;
                case 5: nodosSecundarios=5; break;
            }
            
        }while(opcion!=6);
    }
    
    public static void records(){
        
        for(Mensaje message: maestro.getMensajesProcesados()){
            
            System.out.println("ID: "+ message.getId() +" Temperatura: "+message.getTemperatura()+" Humedad: "+message.getHumedad()+"%"+" Luminiscencia: "+message.getLuminiscencia());
        }
        
    }
    
    public static void start(){
        
        if(velocidadProcesamiento==0 || nodosSecundarios==0){
            System.out.println("Primero indique cuales nodos van a ser activos y la velocidad de procesamiento del nodo maestro");
            return;
        }
        pausado = false; 
        maestro = new NodoMaestro(semaphore, velocidadProcesamiento);
        maestro.start();
        
        for(int i=0; i<nodosSecundarios; i++){
            NodoSecundario nodoSecundario = new NodoSecundario(semaphore, "N"+(i+1));
            nodosEnEjecucion.add(nodoSecundario);
            nodoSecundario.start();
        }
        
    }
    public static void pause(){
                if(velocidadProcesamiento==0 || nodosSecundarios==0){
            System.out.println("Primero inicie el proceso de ejecucion");
            return;
        }
        synchronized(Main.class){
        pausado = true; 
        System.out.println("Se han pausado los hilos");
    }
    }
    public static boolean statusThreads(){
        return pausado; 
    }
    
    public static void restart(){
        pause(); 
        mensajesTotales.clear(); 
        nodosEnEjecucion.clear();
        Semaforo.clearTail();
        NodoMaestro.clearMessage(); 
        velocidadProcesamiento=0; 
        nodosSecundarios=0; 
        System.out.println("Se han reiniciado todos los valores, asigne velocidad de procesamiento y los nodos que desea ejecutar. Seguido presione start");
    }
}
