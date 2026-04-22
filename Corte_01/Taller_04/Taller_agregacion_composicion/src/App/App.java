package App;
import Organizador.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/*ELABORADO POR
* -ALEX DAVID FLOREZ CERRO 0222520031
* -DAVID SANTIAGO ARIAS ROJAS 0222510022
* -ANGEL DANIEL MERCHAN VILLAMIZAR 0222510035 */
//NOTA: LA ID DE LA OFICINA ES O DE OFICINA Y UN NUMERO INT
public class App {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Oficina> oficinas = new ArrayList<>();
    private static ArrayList<Empleado> empleados = new ArrayList<>();
    private static ArrayList<Tarea> tareas = new ArrayList<>();
    private static int contadorOficinas = 0;
    private static int contadorTareas = 0;
    private static int contadorEmpleados = 0;


    public static void main(String[] args) {

        int opc;
        do {
            opc = menuPrincipal();

            switch (opc) {
                case 1:
                    menuGestionOficinas(); break;
                case 2:
                    menuGestionEmpleados(); break;
                case 3:
                    mostrarDatos(); break;
            }
        } while (opc != 4);
    }

    public static int menuPrincipal() {

        int opcion;
        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Gestion de oficinas");
            System.out.println("2. Gestion de empleados");
            System.out.println("3. Imprimir estado del sistema");
            System.out.println("4. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
        } while (opcion < 1 || opcion > 4);
        return opcion;
    }

    public static void menuGestionOficinas(){

        int opcion;
        System.out.println("GESTION DE OFICINAS");

        do{
            System.out.println("1. Registrar oficina");
            System.out.println("2. Eliminar oficina");
            System.out.println("3. Gestion de tareas");
            System.out.println("4. Volver al menu principal");
            opcion=sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1: crearOficina(); break;
                case 2: eliminarOficina(); break;
                case 3: menuGestionTareas(); break;
                case 4: return;
            }
        }while(opcion<1 || opcion>4);
    }

    public static void menuGestionEmpleados(){

        int opcion;
        String idEmpleado;
        System.out.println("GESTION EMPLEADOS");

        do{
            System.out.println("1. Registrar empleado");
            System.out.println("2. Eliminar empleado");
            System.out.println("3. Añadir oficina a un empleado");
            System.out.println("4. Eliminar oficina a un empleado");
            System.out.println("5. Volver al menu principal");
            opcion=sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1: crearEmpleado(); break;
                case 2: eliminarEmpleado();break;
                case 3:
                    System.out.print("Ingrese la ID del empleado al cual quiere añadirle una oficina");
                    idEmpleado=sc.nextLine();

                    while(!validarString(idEmpleado)){
                        System.out.println("Error: La ID no puede estar vacia");
                        idEmpleado=sc.nextLine();
                    }

                    Empleado employee=buscarEmpleado(idEmpleado);

                    if(employee!=null){ agregarOficinasaEmpleado(employee);}
                    else System.out.println("Error: La ID ingresada no aparece como registrada en la organizacion, por favor, vuelva al menu principal e intentelo nuevamente");

                    break;
                    case 4: eliminarEmpleadoDeOficina(); break;

                case 5: return;
            }
            }while(opcion<1 || opcion>5);
    }

    public static void menuGestionTareas(){

        int opcion;
        System.out.println("GESTION DE TAREAS");

        do{
            System.out.println("1. Crear una nueva tarea");
            System.out.println("2. Asignar una tarea ya creada");
            System.out.println("3. Actualizar estado de la tarea");
            System.out.println("4. Volver a gestion de oficinas");
            opcion=sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1: asignarTarea(); break;
                case 2: asignarTareaCreada(); break;
                case 3: actualizarEstado(); break;
                case 4: return;
            }

        }while(opcion<1 || opcion>4);

    }

    public static void asignarTareaCreada(){

        String idOficina;
        String idTarea;
        Tarea homework;
        Oficina office;

        System.out.print("Ingrese la ID de la oficina a la cual quiere asignar la tarea ya creada: ");
        idOficina=sc.nextLine();

        while(!validarString(idOficina)){
            System.out.println("Error: La ID de la oficina no puede estar vacia");
            System.out.print("Ingrese la ID nuevamente: ");
            idOficina=sc.nextLine();
        }

        office=buscarOficina(idOficina);

        if(office==null){
            System.out.println("El ID ingresado no se encuentra en la base de datos, por favor vuelva a intentarlo nuevamente");
            return;
        }

        System.out.print("Ingrese la ID de la tarea que quiere asignar: ");
        idTarea=sc.nextLine();

        while(!validarString(idTarea)){
            System.out.println("Error: La ID de la tarea no puede estar vacia");
            System.out.print("Ingrese la ID nuevamente: ");
            idTarea=sc.nextLine();
        }

        homework=buscarTarea(idTarea);

        if(homework==null){
            System.out.println("El ID ingresado no se encuentra en la base de datos, por favor vuelva a intentarlo nuevamente");
            return;
        }

        office.vincularTareaDeOtraOficina(homework);
        homework.agregarColaborador(office);

    }

    public static void crearOficina() {

        String nombreOficina, descripcionTarea;
        String idOficina, idTarea;

        System.out.println("Diligencie los siguientes datos correctamente para que el registro sea exitoso");
        nombreOficina= tiposDeOficinas();
        System.out.print("El ID de la oficina sera el siguiente: ");
        idOficina="O"+(++contadorOficinas);
        System.out.println(idOficina);
        System.out.println("Para registrar una oficina es necesario asignarle una tarea");
        idTarea="T"+(++contadorTareas);
        System.out.print("La ID que se le asignara a la tarea es: ");
        System.out.println(idTarea);
        descripcionTarea= tiposDeTareas();

        Oficina office = new Oficina(idOficina, nombreOficina);
        Tarea homework=office.registrarTareaPropia(idTarea, idOficina, descripcionTarea);
        tareas.add(homework);
        oficinas.add(office);

        System.out.println("La oficina se creo correctamente");

    }

    public static void eliminarOficina(){

        String idOficina;
        Oficina office;

        System.out.print("Ingrese el ID de la oficina que quiere eliminar");
        idOficina=sc.nextLine();

        while(!validarString(idOficina)){
            System.out.println("Error: La ID de la oficina no puede estar vacia");
            System.out.print("Ingrese la ID nuevamente: ");
            idOficina=sc.nextLine();
        }

        office=buscarOficina(idOficina);

        if(office==null){
            System.out.println("El ID ingresado no se encuentra en la base de datos, por favor vuelva a intentarlo nuevamente");
            return;
        }

        ArrayList<Tarea> tareasDeLaOficina=new ArrayList<>(office.getTareas());

        for(Tarea tareaActual: tareasDeLaOficina){

            if(tareaActual.getIdOficinaCreadora().equals(office.getId())){

                tareas.remove(tareaActual);

                for(Oficina colaborador : tareaActual.getOficinasColaboradoras()){
                    colaborador.eliminarTarea(tareaActual);
                }
            }
            else{

                tareaActual.getOficinasColaboradoras().remove(office);

            }
        }

        ArrayList<Empleado> empleadosDeLaOficina= new ArrayList<>(office.getEmpleados());

        for(Empleado empleadoActual : empleadosDeLaOficina){
            empleadoActual.eliminarOficina(office);

            if(oficinas.size()>1){
                System.out.println("El empleado "+empleadoActual.getNombre()+" se ha quedado sin oficina, a continuacion sera re asignado a otra: ");
                agregarOficinasaEmpleado(empleadoActual);
            }
            else{
                System.out.println("No hay mas oficinas disponibles, el empleado "+empleadoActual.getNombre()+" sera despedido");
                empleados.remove(empleadoActual);
            }
        }

        oficinas.remove(office);
        System.out.println("La oficina se elimino correctamente");

    }

    public static int buscarIdOficina(String id){

        for(int i=0; i<oficinas.size(); i++){
            if(oficinas.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public static Oficina buscarOficina (String idOficina){

        for(Oficina i: oficinas){
            if(i.getId().equals(idOficina)){
                return i;
            }
        }

        return null;
    }

    public static Empleado buscarEmpleado(String idEmpleado){

        for(Empleado i: empleados){
            if(i.getId().equals(idEmpleado)){
                return i;
            }
        }

        return null;
    }

    public static Tarea buscarTarea(String idTarea){

        for(Tarea i: tareas){
            if(i.getId().equals(idTarea)){
                return i;
            }
        }

        return null;
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
            String descripcionTarea= tiposDeTareas();
            Tarea homework=oficinas.get(posicionOficina).registrarTareaPropia(idTarea, idOficina, descripcionTarea);
            tareas.add(homework);
        }
    }

    public static boolean validarString(String texto){
        if(texto!=null && !texto.trim().isEmpty()){ return true; }
        else return false;
    }

    public static String tiposDeOficinas(){

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

    public static String tiposDeTareas(){

        int opcion;

        System.out.println("Menu de tareas");
        System.out.println("Escoja una de las siguientes opciones para asignarle una tarea a la oficina");

        do{
            System.out.println("1. Implementar nuevas medidas de ciberseguridad");
            System.out.println("2. Preparar informe financiero trimestral");
            System.out.println("3. Lanzar campaña publicitaria en redes sociales");
            System.out.println("4. Capacitación de empleados en nuevas herramientas");
            opcion=sc.nextInt();
            sc.nextLine();
        }while(opcion<1 || opcion>4);

        switch(opcion){
            case 1: return "Implementar nuevas medidas de ciberseguridad";
            case 2: return "Preparar informe financiero trimestral";
            case 3: return "Lanzar campaña publicitaria en redes sociales";
            case 4: return "Capacitación de empleados en nuevas herramientas";
            default: return " ";
        }
    }

    public static void crearEmpleado() {

        if(oficinas.isEmpty()){
            System.out.println("Error: No hay oficinas registradas, primero cree una oficina");
            return;
        }

        String nombreEmpleado;
        String idEmpleado;

        System.out.println("Ingrese el nombre del empleado");
        nombreEmpleado=sc.nextLine();

        while(!validarString(nombreEmpleado)){
            System.out.println("Error: El nombre no puede estar vacio");
            nombreEmpleado=sc.nextLine();
        }

        System.out.print("El ID del empleado sera el siguiente: ");
        idEmpleado="E"+(++contadorEmpleados);
        System.out.println(idEmpleado);
        Empleado employee=new Empleado(idEmpleado, nombreEmpleado, menuRol());

        System.out.println("Para terminar de registrar al empleado se necesita asignarlo a una oficina");
        System.out.println("Las oficinas disponibles son las siguientes: ");

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

        int posicionOficina;

        while(buscarIdOficina(idOficina)==-1){
            System.out.println("Error: La ID ingresada no se encuentra registrada, vuelva a intentarlo nuevamente");
            System.out.print("ID: ");
            idOficina=sc.nextLine();
        }

        posicionOficina=buscarIdOficina(idOficina);
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
            opcion=sc.nextInt();
            sc.nextLine();

        }while(opcion<1 || opcion>3);
        switch (opcion){
            case 1: return new Rol("R1","Gerente de Proyecto", 1 );
            case 2: return new Rol("R2","Desarrollador de Software", 2 );
            case 3: return new Rol("R3","Analista de Datos", 3 );
            default: return null;
        }

    }

    public static void mostrarDatos(){
        for(Oficina office: oficinas) {
            System.out.println("Oficina: " + office.getNombre());
            if(office.getEmpleados().isEmpty()){
                System.out.println("La oficina no cuenta con empleados en nomina");
            }

            else {
                System.out.println("Empleados:");
                for (Empleado employee : office.getEmpleados()) {
                    System.out.println("Nombre: " + employee.getNombre() + "| Rol: " + employee.getRol().getNombre() + "| Nivel " + employee.getRol().getNivel());
                }
            }
            for (Tarea task : office.getTareas()) {
                System.out.println("Tarea: " + task.getDescripcion());
                System.out.println("Estado: " + task.getEstado());

            }
        }
    }
    public static void eliminarEmpleado(){
        String idEmpleado;
        System.out.println("Ingrese la ID del empleado que desea eliminar");
        idEmpleado=sc.nextLine();
        Empleado employee =buscarEmpleado(idEmpleado);

        if(employee!=null){
            for(Oficina i: oficinas){
                if(i.getEmpleados().contains(employee)){
                    i.eliminarEmpleado(employee);
                }
            }
            empleados.remove(employee);
            System.out.println("El empleado se ha eliminado correctamente");
        }
        else {
            System.out.println("Error: La ID ingresada no aparece como registrada en la organizacion");
        }
    }

    public static void eliminarEmpleadoDeOficina(){

        String idEmpleado;
        String idOficina;
        System.out.println("Ingrese la ID de la oficina a la cual quiere eliminarle un empleado");
        idOficina=sc.nextLine();
        int posoffice = buscarIdOficina(idOficina);

        if(posoffice!=-1){
            System.out.println("Ingrese la ID del empleado que desea eliminar");
            idEmpleado=sc.nextLine();
            Empleado employee = buscarEmpleado(idEmpleado);

            if(employee!=null){

                if(oficinas.get(posoffice).getEmpleados().contains(employee))
                {
                    Oficina office = oficinas.get(posoffice);
                    office.eliminarEmpleado(employee);
                    employee.eliminarOficina(office);
                    System.out.println("El empleado se ha eliminado correctamente");
                }
            }
            else {
                System.out.println("Error: La ID del empleado ingresada no aparece como registrada en la organizacion");
            }
        }
        else{
            System.out.println("Error: La ID de la oficina ingresada no aparece como registrada en la organizacion");
        }

    }

    public static void actualizarEstado(){
        String idOficina="";
        String idTarea="";
        Oficina office;

        while(buscarOficina(idOficina)==null){
            System.out.println("Ingresar el ID de la oficina: ");
            idOficina=sc.nextLine();
            if(!validarString(idOficina)){
                System.out.println("El ID de la oficina no puede estar vacio ");
                return;
            }
        }
        office=buscarOficina(idOficina);
        while(buscarTarea(idTarea)==null) {
            System.out.println("Ingresar ID de la tarea que quiere marcar como finalizada: ");
            idTarea = sc.nextLine();
                if (!validarString(idTarea)) {
                System.out.println("El id de la tarea no puede estar vacio");
                return;
                }
        }

        for(Tarea i : office.getTareas()){
            if(i.getId().equals(idTarea)){
                office.finalizarTarea(idTarea);
                System.out.println("La tarea ha sido finalizada con exito");
                return;
            }
        }
        System.out.println("La tarea que quiere finalizar no existe en la oficina "+office.getNombre());
    }

}
