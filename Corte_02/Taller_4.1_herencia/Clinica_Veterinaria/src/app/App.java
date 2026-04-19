package app;
import veterinaria.*;

import java.util.ArrayList;
import java.util.Scanner;


/*ELABORADO POR
 * -ALEX DAVID FLOREZ CERRO 0222520031
 * -DAVID SANTIAGO ARIAS ROJAS 0222510022
 * -ANGEL DANIEL MERCHAN VILLAMIZAR 0222510035 */

public class App {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Animal> animales = new ArrayList<>();
    static ArrayList<Dueño> dueños= new ArrayList<>();
    static ArrayList<Veterinario> veterinarios = new ArrayList<>();
    static int contadorAnimales=0;
    static int contadorDueños=0;
    static int contadorVeterinarios;

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
            sc.next();
        }while(opcion<1 || opcion>5);

        return opcion;
    }

    public static void menuRegistros(){

        int opcion;

        System.out.println("MENU DE REGISTROS");

        do {
            System.out.println("1. Registrar animales");
            System.out.println("2. Registrar dueños");
            System.out.println("3. Registrar veterinarios");
            System.out.println("4. Volver al menu principal");
            opcion=sc.nextInt();
            sc.next();

            switch(opcion){
                case 1: registrarAnimales(); break;
                case 2: registrarDueños(); break;
                case 3: registrarVeterinarios(); break;
                case 4: return;
            }

        }while(opcion<1 || opcion>5);
    }

    public static void registrarAnimales(){

        String idMascota;
        String nombreMascota;
        String razaMascota;
        String especieMascota;
        String tamañoMascota;

        System.out.println("REGISTRO DE ANIMALES");

        idMascota="A"+(++contadorAnimales);
        System.out.println("ID del animal: "+idMascota);

        System.out.print("Ingrese el nombre que va a recibir el animal: ");
        nombreMascota=sc.nextLine();

        System.out.println(" ");
        System.out.print("Ingrese la especie del animal: ");
        especieMascota=sc.nextLine();

        System.out.println(" ");
        System.out.print("Ingrese la raza del animal: ");
        razaMascota=sc.nextLine();

        System.out.println(" ");
        System.out.println("Ingrese el tamaño del animal");
        tamañoMascota=sc.nextLine();

        Animal mascota = new Animal(idMascota, nombreMascota, razaMascota, tamañoMascota, especieMascota);
        animales.add(mascota);

        System.out.println(" ");
        System.out.println("Se completo el registro con exito");
        System.out.println(" ");

    }

    public static void registrarDueños(){

        String idDueño;
        String correoElectronico;
        String metodoPago;
        String nombreDueño;
        long telefonoDueño;
        String direccionDueño;

        System.out.println("REGISTRO DE DUEÑOS");

        idDueño="D"+(++contadorDueños);
        System.out.println("El ID del dueño sera: "+idDueño);

        System.out.print("Ingrese el nombre del dueño: ");
        nombreDueño=sc.nextLine();

        System.out.println(" ");
        System.out.print("Ingrese el correo electronico del dueño: ");
        correoElectronico=sc.nextLine();

        System.out.println(" ");
        System.out.print("Ingrese el metodo de pago del dueño: ");
        metodoPago=sc.nextLine();

        System.out.println(" ");
        System.out.print("Ingrese la direccion de la vivienda del dueño: ");
        direccionDueño=sc.nextLine();

        System.out.println(" ");
        System.out.print("Ingrese el numero de telefono del dueño");
        telefonoDueño=sc.nextLong();

        Dueño dueño = new Dueño(idDueño, correoElectronico, metodoPago, nombreDueño, direccionDueño, telefonoDueño);
        dueños.add(dueño);

        System.out.println(" ");
        System.out.println("El registro se completo con exito");
        System.out.println(" ");

    }

    public static void registrarVeterinarios(){

        String numeroLicencia;
        String nombreVeterinario;
        String especialidad;
        int añosExperiencia;
        long telefonoVeterinario;
        String direccionVeterinario;

        System.out.println("REGISTRO DE VETERINARIOS");

        numeroLicencia="V"+(++contadorVeterinarios);

        System.out.println("El ID del veterinario sera: "+numeroLicencia);

        System.out.print("Ingrese el nombre del veterinario: ");
        nombreVeterinario=sc.nextLine();

        System.out.println(" ");
        System.out.print("Ingrese la especialidad del veterinario: ");
        especialidad=sc.nextLine();

        System.out.println(" ");
        System.out.print("Ingrese los años de experiencia del veterinario: ");
        añosExperiencia=sc.nextInt();

        System.out.println(" ");
        System.out.print("Ingrese la direccion de la vivienda del veterinario: ");
        direccionVeterinario=sc.nextLine();

        System.out.println(" ");
        System.out.print("Ingrese el numero de telefono del veterinario");
        telefonoVeterinario=sc.nextLong();

        Veterinario veterinario = new Veterinario(numeroLicencia, especialidad, añosExperiencia, nombreVeterinario, direccionVeterinario, telefonoVeterinario);
        veterinarios.add(veterinario);

        System.out.println(" ");
        System.out.println("El registro se completo con exito");
        System.out.println(" ");

    }

}
