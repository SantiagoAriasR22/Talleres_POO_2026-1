package App;
import Organizador.*;

import java.util.ArrayList;
import java.util.Scanner;


public class App {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Oficina> oficinas = new ArrayList<>();
    private static ArrayList<Empleado> empleados = new ArrayList<>();
    //private static ArrayList<Tarea> task = new ArrayList<>();
    private static int contadorOficinas=0;
    private static int contadorTareas=0;
    private static int contadorEmpleados=0;
    private static int contadorRoles=0;

    public static void main(String[] args) {

        int opc;
        do {
            opc = menuPrincipal();

            switch(opc){
                case 1: crearOficina(); break;
                case 2: asignarTarea(); break;
                case 3: crearEmpleado(); break;
                case 4: mostrarDatos(); break;
            }
        } while (opc != 4);
    }

    public static int menuPrincipal() {

        int opcion;
        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Registrar Oficina");
            System.out.println("2. Registrar una tarea");
            System.out.println("3. Registrar un empleado");
            System.out.println("4. Mostrar datos");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
        } while (opcion < 1 || opcion > 5);
        return opcion;
    }

    public static void crearOficina() {

        String nombreOficina, descripcionTarea;
        String idOficina, idTarea;

        System.out.println("Diligencie los siguientes datos correctamente para que el registro sea exitoso");
        nombreOficina=menuOficinas();
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

    public static String menuOficinas(){

        int opcion;

        do{
            System.out.println("1. Departamento de tecnologia");
            System.out.println("2. Recursos humanos");
            System.out.println("3. Finanzas y contabilidad");
            System.out.println("4. Marketing y publicidad");
            System.out.println("5. Atencion al cliente");
            opcion=sc.nextInt();
            sc.nextLine();
        }while(opcion<1 || opcion>5);

        switch(opcion){
            case 1: return "Departamento de tecnologia";
            case 2: return "Recursos humanos";
            case 3: return "Finanzas y contabilidad";
            case 4: return "Marketing y publicidad";
            case 5: return "Atencion al cliente";

            default: return "";
        }
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

    public static void crearEmpleado() {

        String nombreEmpleado;
        String idEmpleado;
        String rol;

        System.out.println("Ingrese el nombre del empleado");
        nombreEmpleado=sc.nextLine();

        while(!validarString(nombreEmpleado)){
            System.out.println("Error: El nombre no puede estar vacio");
            nombreEmpleado=sc.nextLine();
        }

        System.out.println("El ID del empleado sera el siguiente: ");
        idEmpleado="E"+(++contadorEmpleados);
        System.out.println(idEmpleado);
        Empleado employee=new Empleado(idEmpleado, nombreEmpleado, menuRol()); //es con dos e, ya le diste a rename? si


        System.out.println("Para terminar de registrar al empleado se necesita asignarlo a una oficina");
        System.out.println("Las oficinas disponibles son las siguientes");

        Oficina oficinaRegistrada=agregarOficinasaEmpleado(employee);
        employee.agregarOficina(oficinaRegistrada);

        empleados.add(employee);
    }

    public static Oficina agregarOficinasaEmpleado(Empleado employee){

        String idOficina;

        for (Oficina i: oficinas){
            System.out.println("Nombre: "+ i.getNombre());
            System.out.println("ID: "+ i.getId());
        }

        System.out.print("Ingrese la ID de la oficina en la cual quiere registrar al empleado: ");
        idOficina=sc.nextLine();

        while(!validarString(idOficina)){
            System.out.println("Error: La ID no puede estar vacia");
            idOficina=sc.nextLine();
        }

        int posicionOficina=buscarIdOficina(idOficina);
        oficinas.get(posicionOficina).agregarEmpleado(employee);

        return oficinas.get(posicionOficina);

    }

    public static Rol menuRol(){
        int opcion;

        System.out.println("Menu de roles");
        System.out.println("Escoja una de las siguientes opciones para asignarle un rol a un empleado");

        do{
            System.out.println("1. Gerente de Proyecto");
            System.out.println("2. Desarrollador de Software");
            System.out.println("3. Analista de Datos");
            System.out.println("4. Asigne otro rol");
            opcion=sc.nextInt();
            sc.nextLine();
//            if(opcion==4){
//                crearRol();
//            }

        }while(opcion<0 || opcion>4);
        switch (opcion){
            case 1: return new Rol("R"+(++contadorRoles),"Gerente de Proyecto", 1 );
            case 2: return new Rol("R"+(++contadorRoles),"Desarrollador de Software", 2 );
            case 3: return new Rol("R"+(++contadorRoles),"Analista de Datos", 3 );
            case 4: return rolPerso();
            default: return null;
        }

    }

    public static Rol rolPerso(){
        String rol;
        int lvl;
        String idRol;
        System.out.println("Ingrese el rol del empleado");
        rol=sc.nextLine();
        System.out.println("Ingrese el nivel del rol");
        lvl=sc.nextInt();
        System.out.println("El ID del rol sera el siguiente: ");
        idRol="R"+(++contadorRoles);
        System.out.println(idRol);
        return new Rol(idRol, rol, lvl);

    }
    public static void mostrarDatos(){
        for(Oficina office: oficinas) {
            System.out.println("Oficina: " + office.getNombre());
            System.out.println("Empleados:");
            for(Empleado employee : office.getEmpleados()) {
                System.out.println("Nombre: "+employee.getNombre()+" Rol: "+ employee.getRol().getNombre()+" Nivel"+employee.getRol().getNivel());
            }

            for(Tarea task: office.getTareas()){
                System.out.println("Tarea: "+task.getDescripcion());
                System.out.println("Estado: "+task.getEstado());

            }
        }
    }
}