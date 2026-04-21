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
                case 2: menuAdopciones(); break;
            }
        }while(opcion!=5);

    }

    public static int menuPrincipal(){

        int opcion;

        System.out.println("MENU PRINCIPAL");

        do {
            System.out.println("1. Registros");
            System.out.println("2. Menu de adopciones");
            System.out.println("3. Registrar un tratamiento aplicado a un animal por un veterinario");
            System.out.println("4. Mostrar informacion de animales y sus tratamientos");
            System.out.println("5. Salir");
            opcion=sc.nextInt();
            sc.nextLine();
        }while(opcion<1 || opcion>5);

        return opcion;
    }

    public static void menuAdopciones(){

        int opcion;

        System.out.println("MENU ADOPCIONES");

        do{
            System.out.println("1. Adoptar un animal");
            System.out.println("2. Transferencia de dueño");
            System.out.println("3. Desvincular dueño de animal");
            opcion=sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1: adoptarAnimales(); break;
                case 2: transferirAnimal(); break;
                case 3: desvincularAnimal(); break;
            }
        }while(opcion<1 || opcion>3);

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
            sc.nextLine();

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

    public static Dueño buscarDueño(String id){

        for(Dueño index: dueños){
            if(index.getId().equals(id)){
                return index;
            }
        }

        return null;
    }

    public static Animal buscarAnimal(String id){

        for(Animal index: animales){
            if(index.getId().equals(id)){
                return index;
            }
        }

        return null;
    }

    public static Animal buscarAnimalDeTransferencia(String id, Dueño dueñoPartida){

        for(Animal index: dueñoPartida.getMascotas()){
            if(index.getId().equals(id)){
                return index;
            }
        }

        return null;
    }

    public static void adoptarAnimales(){

        String idDueño;
        String idAnimal;
        Dueño dueño;
        Animal animal;

        System.out.print("Ingrese el ID de la persona que quiere ser dueño de un animal: ");
        idDueño=sc.nextLine();

        dueño=buscarDueño(idDueño);

        System.out.println(" ");
        if(dueño==null){
            System.out.println("La ID escrita anteriormente no se encuentra registrada, vuelva al menu principal y vuelva intentarlo");
            return;
        }

        System.out.println("==========Informacion de la persona==========");
        System.out.println("Nombre: "+dueño.getNombre());
        System.out.println("ID: "+dueño.getId());
        System.out.println("Telefono: "+dueño.getTelefono());
        System.out.println("Direccion: "+dueño.getDireccion());
        System.out.println("Correo electronico: "+dueño.getCorreoElectronico());
        System.out.println("Metodo de pago: "+dueño.getMetodoPago());
        System.out.println("Cantidad de mascotas: "+dueño.getMascotas().size());
        System.out.println("=============================================");

        System.out.println(" ");
        System.out.println("Animales disponibles para adoptar: ");

        for(Animal index: animales){

            System.out.println(" ");

            if(index.getDueño()==null){
                System.out.println("ID: "+index.getId());
                System.out.println("Nombre: "+index.getNombre());
                System.out.println("Especie: "+index.getEspecie());
                System.out.println("Raza: "+index.getRaza());
                System.out.println("Tamaño: "+index.getTamaño());

                System.out.println(" ");
            }
        }

        System.out.print("Ingrese el ID del animal que desea adoptar");
        idAnimal=sc.nextLine();

        animal=buscarAnimal(idAnimal);

        System.out.println(" ");
        if(animal==null){
            System.out.println("La ID escrita anteriormente no se encuentra registrada, vuelva al menu principal y vuelva intentarlo");
            return;
        }

        animal.setDueño(dueño);
        animal.getHistoriaClinica().doAgregarDueño(dueño);
        dueño.doAgregarMascota(animal);

        System.out.println("Se completo el proceso de adopcion");
        System.out.println(" ");

    }

    public static void transferirAnimal(){

        Animal animal;
        Dueño dueñoPartida;
        Dueño dueñoDestino;
        String idAnimal;
        String idDueñoPartida;
        String idDueñoDestino;

        System.out.print("Ingrese la ID de la persona/dueño que quiere transferir al animal");
        idDueñoPartida=sc.nextLine();

        dueñoPartida=buscarDueño(idDueñoPartida);

        System.out.println(" ");
        if(dueñoPartida==null){
            System.out.println("La ID escrita anteriormente no se encuentra registrada, vuelva al menu principal y vuelva intentarlo");
            return;
        }

        System.out.println(" ");
        System.out.println("==========Animales disponibles para la transferencia==========");

        for(Animal index: dueñoPartida.getMascotas()){
            System.out.println("ID: "+index.getId());
            System.out.println("Nombre: "+index.getNombre());
            System.out.println("Especie: "+index.getEspecie());
            System.out.println("Raza: "+index.getRaza());
            System.out.println("Tamaño: "+index.getTamaño());

            System.out.println(" ");
        }

        System.out.print("Ingrese el ID del animal que quiere transferir: ");
        idAnimal=sc.nextLine();

        animal=buscarAnimalDeTransferencia(idAnimal, dueñoPartida);

        System.out.println(" ");
        if(animal==null){
            System.out.println("La ID escrita anteriormente no se encuentra registrada o el animal no esta vinculado con el dueño, vuelva al menu principal y vuelva intentarlo");
            return;
        }

        System.out.print("Ingrese la ID de la persona/dueño a la que se le va a transferir el animal: ");
        idDueñoDestino=sc.nextLine();

        dueñoDestino=buscarDueño(idDueñoDestino);

        System.out.println(" ");
        if(dueñoDestino==null){
            System.out.println("La ID escrita anteriormente no se encuentra registrada, vuelva al menu principal y vuelva intentarlo");
            return;
        }

        dueñoPartida.doEliminarMascota(animal);
        animal.doEliminarDueño();
        dueñoDestino.doAgregarMascota(animal);
        animal.setDueño(dueñoDestino);
        animal.getHistoriaClinica().doAgregarDueño(dueñoDestino);

        System.out.println("Se realizo con exito la transferencia del animal");
    }

    public static void desvincularAnimal(){

        String idAnimal;
        String idDueño;
        Animal animal;
        Dueño dueño;

        System.out.print("Ingrese la ID del dueño al cual quiere desvincularle un animal: ");
        idDueño=sc.nextLine();

        dueño=buscarDueño(idDueño);

        System.out.println(" ");
        if(dueño==null){
            System.out.println("La ID escrita anteriormente no se encuentra registrada, vuelva al menu principal y vuelva intentarlo");
            return;
        }

        System.out.println(" ");
        System.out.println("==========Animales de "+dueño.getNombre()+"==========");

        for(Animal index: dueño.getMascotas()){
            System.out.println("ID: "+index.getId());
            System.out.println("Nombre: "+index.getNombre());
            System.out.println("Especie: "+index.getEspecie());
            System.out.println("Raza: "+index.getRaza());
            System.out.println("Tamaño: "+index.getTamaño());

            System.out.println(" ");
        }

        System.out.print("Ingrese la ID del animal que desea desvincular del dueño: ");
        idAnimal=sc.nextLine();

        animal=buscarAnimalDeTransferencia(idAnimal, dueño);

        if(animal==null){
            System.out.println("La ID escrita anteriormente no se encuentra registrada o el animal no esta vinculado con el dueño, vuelva al menu principal y vuelva intentarlo");
            return;
        }

        animal.doEliminarDueño();
        dueño.doEliminarMascota(animal);

        System.out.println("Se desvinculo correctamente el animal del dueño");

    }

}
