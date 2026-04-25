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
    static ArrayList<Tratamiento> tratamientos = new ArrayList<>();
    static int contadorAnimales=0;
    static int contadorDueños=0;
    static int contadorVeterinarios=0;
    static int contadorTratamientos=0;

    public static void main(String[] args){

        int opcion;

        do{
            opcion=menuPrincipal();

            switch(opcion){
                case 1: menuRegistros(); break;
                case 2: menuAdopciones(); break;
                case 3: registroTratamiento();break;
                case 4: subMenuMostrarDatos();break;
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
            System.out.println("4. Volver al menu principal");
            opcion=sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1: adoptarAnimales(); break;
                case 2: transferirAnimal(); break;
                case 3: desvincularAnimal(); break;
            }
        }while(opcion<1 || opcion>4);

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

        System.out.print("Ingrese la especie del animal: ");
        especieMascota=sc.nextLine();

        System.out.print("Ingrese la raza del animal: ");
        razaMascota=sc.nextLine();

        System.out.print("Ingrese el tamaño del animal: ");
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

        System.out.print("Ingrese el correo electronico del dueño: ");
        correoElectronico=sc.nextLine();

        System.out.print("Ingrese el metodo de pago del dueño: ");
        metodoPago=sc.nextLine();

        System.out.print("Ingrese la direccion de la vivienda del dueño: ");
        direccionDueño=sc.nextLine();

        System.out.print("Ingrese el numero de telefono del dueño: ");
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

        System.out.print("Ingrese la especialidad del veterinario: ");
        especialidad=sc.nextLine();

        System.out.print("Ingrese los años de experiencia del veterinario: ");
        añosExperiencia=sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese la direccion de la vivienda del veterinario: ");
        direccionVeterinario=sc.nextLine();

        System.out.print("Ingrese el numero de telefono del veterinario: ");
        telefonoVeterinario=sc.nextLong();
        sc.nextLine();

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
    public static Veterinario buscarVeterinario(String id){
        for (Veterinario index: veterinarios){
            if(index.getNumeroLicencia().equals(id)){
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

        System.out.print("Ingrese la ID de la persona/dueño que quiere transferir al animal: ");
        idDueñoPartida=sc.nextLine();

        dueñoPartida=buscarDueño(idDueñoPartida);

        if(dueñoPartida==null){
            System.out.println("La ID escrita anteriormente no se encuentra registrada, vuelva al menu principal y vuelva intentarlo");
            return;
        }

        if(dueñoPartida.getMascotas().isEmpty()){
            System.out.println("Esta persona no tiene ningun mascota, por lo que no sera posible la transferencia, vuelva al menu principal");
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

        System.out.println("=============================================================");

        System.out.print("Ingrese el ID del animal que quiere transferir: ");
        idAnimal=sc.nextLine();

        animal=buscarAnimalDeTransferencia(idAnimal, dueñoPartida);

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

        if(dueño==null){
            System.out.println("La ID escrita anteriormente no se encuentra registrada, vuelva al menu principal y vuelva intentarlo");
            return;
        }

        if(dueño.getMascotas().isEmpty()){
            System.out.println("Esta persona no tiene mascotas, por lo que no sera posible desvincular algun animal, regrese al menu");
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

    public static void registroTratamiento(){

        String idAnimal, nroVeterinario, idTratamiento="T"+(++contadorTratamientos), nombreTratamiento, descripcionTratamiento;
        Animal animal;
        Veterinario veterinario;

        if(veterinarios.isEmpty() || animales.isEmpty()){
            System.out.println("No hay veterinarios o animales registrados, vuelva al menu principal y vuelva a intentarlo");
            return;
        }

        System.out.println("REGISTRO DE TRATAMIENTOS");
        System.out.println("Para proceder con el registro de un tratamiento, debe seleccionar un animal y un veterinario.");

        System.out.print("Ingrese la ID del animal: ");
        idAnimal=sc.nextLine();
        animal=buscarAnimal(idAnimal);

        if(animal==null){
            System.out.println("La ID escrita anteriormente no se encuentra registrada, vuelva al menu principal y vuelva intentarlo");
            return;
        }

        System.out.println("A continuacion se muestran todos los veterinarios disponibles: ");
        System.out.println(" ");

        System.out.println("==========VETERINARIOS==========");
        for(Veterinario index: veterinarios){
            System.out.println(index.getNumeroLicencia()+" - "+index.getNombre());
            System.out.println("Especialidad: "+index.getEspecialidad());
            System.out.println("Años de Experiencia: "+index.getAñosExperiencia());
                if(!(index.getPacientes().isEmpty())){
                    System.out.println("Pacientes: "+index.getPacientes().size());
                }
                else{
                    System.out.println("No cuenta con pacientes");
                }
        }

        System.out.println("===============================");

        do{
            System.out.print("Ingrese el numero de licencia del veterinario: ");
            nroVeterinario=sc.nextLine();
        }while(buscarVeterinario(nroVeterinario)==null);

        veterinario=buscarVeterinario(nroVeterinario);

        System.out.print("Ingrese el nombre del tratamiento: ");
        nombreTratamiento=sc.nextLine();
        System.out.print("Ingrese la descripcion del tratamiento: ");
        descripcionTratamiento=sc.nextLine();
        Tratamiento tratamiento= new Tratamiento(idTratamiento, nombreTratamiento, descripcionTratamiento);
        tratamientos.add(tratamiento);
        veterinario.setAgregarPaciente(animal);
        veterinario.doAgregarTratamiento(animal, tratamiento);

        System.out.println(" ");
        System.out.println("Se registro el tratamiento con exito");
        System.out.println(" ");
    }

    public static void subMenuMostrarDatos(){
        int opc;
        System.out.println("MOSTRAR DATOS");
        System.out.println("1. Mostrar informacion de un animal");
        System.out.println("2. Mostrar los datos de todos los animales");
        do {
             opc=sc.nextInt();
             sc.nextLine();
        }while(opc>2 || opc<1);

       datosAnimal(opc);
    }

    public static void datosAnimal(int opc){
        String idAnimal;
        Animal animal;

       if(opc==1) {
           System.out.print("Ingrese la ID del animal que desea consultar: ");
           idAnimal = sc.nextLine();
           animal = buscarAnimal(idAnimal);
           if (animal == null) {
               System.out.println("La ID escrita anteriormente no se encuentra registrada, vuelva al menu principal y vuelva intentarlo");
               return;
           }
           mostrarDatos(animal);
       }
       else if(opc==2){
           for(Animal index: animales){
               mostrarDatos(index);
           }
       }
    }

    public static void mostrarDatos(Animal animal){

        System.out.println("Nombre animal: "+animal.getNombre());
        System.out.println("ID animal: "+animal.getId());
        System.out.println("Especie animal :"+animal.getEspecie());
        System.out.println("Raza animal: "+ animal.getRaza());
        System.out.println("Tamaño animal: "+ animal.getTamaño());
        if(animal.getDueño()==null){
            System.out.println("El animal no tiene dueño");
        }
        else{
            System.out.println("Dueño actual del animal: "+ animal.getDueño().getNombre());
        }

        System.out.println("HISTORIA CLINICA");
        System.out.println("ID historia clinica: "+animal.getHistoriaClinica().getId());
        if(animal.getHistoriaClinica().getTratamientos().isEmpty()){
            System.out.println("No hay tratamientos registrados");
        }
        else {
            for(Tratamiento index: animal.getHistoriaClinica().getTratamientos()){
                System.out.println("ID del tratamiento: "+index.getId());
                System.out.println("Nombre del tratamiento: "+index.getNombreDelTratamiento());
                System.out.println("Descripcion del tratamiento: "+index.getDescripcionDelTratamiento());
                System.out.println("Fecha del tratamiento: "+index.getFechaTratamiento());
            }
        }
    }
}