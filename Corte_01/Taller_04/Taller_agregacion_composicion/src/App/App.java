package App;
import Organizador.*;

import java.util.ArrayList;
import java.util.Scanner;


public class App {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Oficina> oficinas = new ArrayList<>();
    private static int contadorOficinas=0;
    private static int contadorTareas=0;

    public static void main(String[] args) {

        int opc;
        do {
            opc = menuPrincipal();

            switch(opc){
                case 1: crearOficina(); break;
                case 2: asignarTarea(); break;
            }
        } while (opc != 3);
    }

    public static int menuPrincipal() {

        int opcion;
        do {
            System.out.println("1. Registrar Oficina");
            System.out.println("2. Registrar una tarea");
            System.out.println("3. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
        } while (opcion < 1 || opcion > 3);
        return opcion;
    }

    public static void crearOficina() {

        String nombreOficina, descripcionTarea;
        String idOficina, idTarea;

        System.out.println("Diligencie los siguientes datos correctamente para que el registro sea exitoso");
        System.out.println("Ingrese el nombre de la oficina");
        nombreOficina = sc.nextLine();
        System.out.print("El ID de la oficina sera el siguiente: ");
        idOficina="O"+(++contadorOficinas);
        System.out.println(idOficina);
        System.out.println("Para registrar una oficina es necesario asignarle una tarea");
        idTarea="T"+(++contadorTareas);
        System.out.println("La ID que se le asignara a la tarea es: ");
        System.out.println(idTarea);
        descripcionTarea=menuTareas();

        Oficina office = new Oficina(idOficina, nombreOficina, idTarea, descripcionTarea);
        oficinas.add(office);

    }

    public static int buscarIdOficina(String id){

        for(int i=0; i<oficinas.size(); i++){
            if(oficinas.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public static void asignarTarea() {

        String idOficina;

        System.out.println("Ingrese la ID de la oficina a la cual le quiere asignar una tarea");
        idOficina=sc.nextLine();

        while(!validarString(idOficina)){
            System.out.println("Error: La ID no puede estar vacia");
            System.out.println("Ingrese la ID nuevamente");
            idOficina=sc.nextLine();
        }

        int posicionOficina=buscarIdOficina(idOficina);

        if(posicionOficina==-1){
            System.out.println("El ID ingresado no se encuentra en la base de datos, por favor vuelva a intentarlo nuevamente");
        }
        else{

            System.out.println("Oficina: "+ oficinas.get(posicionOficina).getNombre());
            System.out.println("La ID que se le asignara a la tarea es: ");
            String idTarea="T"+(++contadorTareas);
            System.out.println(idTarea);
            String descripcionTarea=menuTareas();
            oficinas.get(posicionOficina).registrarTarea(idTarea, descripcionTarea);
        }

    }

    public static boolean validarString(String texto){

        if(texto!=null && !texto.trim().isEmpty()){ return true; }
        else return false;
    }

    public static String menuTareas(){

        int opcion;

        System.out.println("Menu de tareas");
        System.out.println("Escoja una de las siguientes opciones para asignarle una tarea a la oficina");

        do{
            System.out.println("1. Implementar nuevas medidas de ciberseguridad");
            System.out.println("2. Preparar informe financiero trimestral");
            System.out.println("3. Lanzar campaña publicitaria en redes sociales");
            System.out.println("4. Capacitación de empleados en nuevas herramientas");
            System.out.println("5. Asigne otra tarea");
            opcion=sc.nextInt();
            sc.nextLine();
        }while(opcion<0 || opcion>6);

        switch(opcion){

            case 1: return "Implementar nuevas medidas de ciberseguridad";
            case 2: return "Preparar informe financiero trimestral";
            case 3: return "Lanzar campaña publicitaria en redes sociales";
            case 4: return "Capacitación de empleados en nuevas herramientas";
            case 5:

                String descripcion;
                System.out.println("Ingrese la descripcion de la tarea: ");
                descripcion=sc.nextLine();

                while(!validarString(descripcion)){
                    System.out.println("Error: La descripcion no puede estar vacia");
                    System.out.println("Ingrese la descripcion nuevamente");
                    descripcion=sc.nextLine();
                }

                return descripcion;

            default: return " ";
        }
    }
}