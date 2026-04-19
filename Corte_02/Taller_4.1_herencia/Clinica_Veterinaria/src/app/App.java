package app;
import veterinaria.*;

import java.util.Scanner;

public class App {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        int opcion;

        do{
            opcion=menuPrincipal();

            switch(opcion){
                case 1: menuRegistros(); break;

            }
        }while(opcion!=5);

    }

    public static int menuPrincipal(){

        int opcion;

        System.out.println("MENU PRINCIPAL");

        do {
            System.out.println("1. Registros");
            System.out.println("2. Asociar animales con dueños");
            System.out.println("3. Registrar un tratamiento aplicado a un animal por un veterinario");
            System.out.println("4. Mostrar informacion de animales y sus tratamientos");
            System.out.println("5. Salir");
            opcion=sc.nextInt();
        }while(opcion<1 || opcion>5);

        return opcion;
    }

    public static int menuRegistros(){

        int opcion;

        System.out.println("MENU DE REGISTROS");

        do {
            System.out.println("1. Registrar animales");
            System.out.println("2. Registrar dueños");
            System.out.println("3. Registrar veterinarios");
            System.out.println("4. Volver al menu principal");
            opcion=sc.nextInt();
        }while(opcion<1 || opcion>5);

        return opcion;
    }

}
