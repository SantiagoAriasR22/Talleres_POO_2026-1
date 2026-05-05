package App;

import FigurasGeometricas.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/*ELABORADO POR
 * -ALEX DAVID FLOREZ CERRO 0222520031
 * -DAVID SANTIAGO ARIAS ROJAS 0222510022
 * -ANGEL DANIEL MERCHAN VILLAMIZAR 0222510035 */

public class App {

    static ArrayList<Figura> figuras = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        App rf = new App();
        rf.begin();

        int opcion;

        do{

            opcion=mainMenu();

            switch(opcion){
                case 1: buscarFigura(); break;
                case 2: modificarFigura(); break;
                case 3:
                    for(Figura f : figuras)
                    {
                        System.out.println("- - - - - - - - - - - - -");
                        System.out.println("Tipo de figura: "+f.getTipoFig());
                        System.out.println("ID: "+f.getId());
                        System.out.println("El color es: "+f.getColor());
                        if(f.getTipoFig().equals("Triangulo") && Double.isNaN(f.doCalcularArea())) {
                            System.out.println("El triangulo no puede ser construido geometricamente");
                        }
                        else {
                            System.out.println("Su area es : " + f.doCalcularArea());
                            System.out.println("Su perimetro es : " + f.doCalcularPerimetro());
                        }
                        System.out.println("- - - - - - - - - - - - -");
                    }
                    break;

                case 4: break;
                case 5: break;
            }

        }while(opcion!=6);

    }

    public static void modificarFigura(){

        int idBuscada;
        Figura figura;

        System.out.print("Ingrese el ID de la figura que quiere modificar: ");
        idBuscada=sc.nextInt();

        System.out.println(" ");

        figura=encontrarFigura(idBuscada);

        if(figura==null){
            System.out.println("La ID de la figura digitada no existe, por favor vuelva al menu e intentelo nuevamente");
            return;
        }
        switch(figura.getTipoFig()){

            case "Pentagono":
                Pentagono pentagono=(Pentagono) figura;
                modificarPentagono(pentagono);
                break;

            case "Circulo":
                Circulo circulo=(Circulo) figura;
                modificarCirculo(circulo);
                break;

            case "Rectangulo":
                Rectangulo rectangulo=(Rectangulo) figura;

                break;
        }

    }

    public static void modificarRectangulo(Rectangulo rectangulo){

        int opcion;

        do {
            System.out.println("Los siguientes atributos del rectangulo se pueden modificar: ");
            System.out.println("1. Color");
            System.out.println("2. Base");
            System.out.println("3. Altura");

            System.out.println("Cual quiere modificar?: ");
            opcion=sc.nextInt();
            sc.nextLine();

        }while (opcion<1 || opcion>3);

        switch(opcion){
            case 1: cambiarColor(rectangulo); break;
            case 2:
                double base;

                do {
                    System.out.print("Ingrese el nuevo valor que va a tener la base: ");
                    base=sc.nextInt();
                    sc.nextLine();

                    if(base<=0) System.out.println("La base tiene que ser mayor a cero");

                }while(base<=0);

                rectangulo.setBase(base);

                System.out.println("Se modifico la base con exito");
                break;

            case 3:
                double altura;

                do{
                    System.out.print("Ingrese el nuevo valor que va a tener la altura: ");
                    altura=sc.nextInt();
                    sc.nextLine();

                    if(altura<=0) System.out.println("La altura tiene que ser mayor a cero");

                }while(altura<=0);

                rectangulo.setAltura(altura);

                System.out.println("Se modifico la altura con exito");
                break;
        }
    }

    public static void modificarCirculo(Circulo circulo){

        int opcion;

        do{
            System.out.println("Los siguientes atributos del circulo se pueden modificar: ");
            System.out.println("1. Color");
            System.out.println("2. Tamaño del diametro");

            System.out.println("Cual quiere modificar?: ");
            opcion=sc.nextInt();
            sc.nextLine();

        }while(opcion<1 || opcion>2);

        if(opcion==1){
            cambiarColor(circulo);
        }
        else{
            double diametro;

            do {
                System.out.print("Ingrese el nuevo tamaño que van a tener el diametro: ");
                diametro=sc.nextDouble();
                sc.nextLine();

                if(diametro<=0) System.out.println("El diametro tiene que ser mayor a cero");

            }while(diametro<=0);

            circulo.setDiametro(diametro);

            System.out.println("Se modifico el valor del diametro con exito");
        }
    }

    public static void modificarPentagono(Pentagono pentagono){

        int opcion;

        do{
            System.out.println("Los siguientes atributos del pentagono se pueden modificar: ");
            System.out.println("1. Color");
            System.out.println("2. Tamaño de los lados");

            System.out.println("Cual quiere modificar?: ");
            opcion=sc.nextInt();
            sc.nextLine();

        }while(opcion<1 || opcion>2);

        if(opcion==1){
            cambiarColor(pentagono);
        }
        else{
            double lados;

            do {
                System.out.print("Ingrese el nuevo tamaño que van a tener los lados: ");
                lados=sc.nextDouble();
                sc.nextLine();

                if(lados<=0) System.out.println("Los lados tienen que ser mayores a cero");

            }while(lados<=0);

            pentagono.setLados(lados);

            System.out.println("Se modifico el valor de los lados con exito");
        }

    }

    public static void cambiarColor(Figura figura){

        int opcion;

        do {
            System.out.print("Seleccione el color que quiere asignarle a la figura: ");
            System.out.println("1. Rojo");
            System.out.println("2. Azul");
            System.out.println("3. Amarillo");
            opcion=sc.nextInt();
            sc.nextLine();

        }while(opcion<1 || opcion >3);

        switch (opcion){
            case 1: figura.setColor("Rojo"); break;
            case 2: figura.setColor("Azul"); break;
            case 3: figura.setColor("Amarillo"); break;
        }

        System.out.println(" ");
        System.out.println("Se cambio el color de la figura con exito");
    }

    public static void buscarFigura(){

        int idBuscada;
        Figura figura;

        System.out.print("Ingrese el ID de la figura que quiere buscar: ");
        idBuscada=sc.nextInt();
        sc.nextLine();

        System.out.println(" ");

        figura=encontrarFigura(idBuscada);

        if(figura==null){
            System.out.println("La ID de la figura digitada no existe, por favor vuelva al menu e intentelo nuevamente");
            return;
        }

        System.out.println("==========DATOS DE LA FIGURA=========");
        System.out.println("ID: "+figura.getId());
        System.out.println("Tipo de figura: "+figura.getTipoFig());
        System.out.println("Color: "+figura.getColor());
        System.out.println("Area: "+figura.doCalcularArea());
        System.out.println("Perimetro: "+figura.doCalcularPerimetro());
        System.out.println("=====================================");

    }

    public static Figura encontrarFigura(int idBuscada){

        for(Figura f: figuras){
            if(f.getId()==idBuscada){
                return f;
            }
        }
        return null;
    }

    public static int mainMenu(){

        int opcion;

        System.out.println(" ");
        System.out.println("MENU PRINCIPAL");

        do{
            System.out.println("1. Buscar figura mediante la ID");
            System.out.println("2. Cambiar datos de figura mediante la ID");
            System.out.println("3. Mostrar todas las figuras");
            System.out.println("4. Mostrar figuras inexistentes");
            System.out.println("5. Mostrar un tipo de figura");
            System.out.println("6. Salir");
            opcion=sc.nextInt();
            sc.nextLine();

        }while(opcion>6 || opcion<1);

        return opcion;
    }

    void begin() {

        File in = new File("data\\data.txt");

        try {

            BufferedReader br = new BufferedReader(new FileReader(in));
            String s;

            while ((s = br.readLine()) != null) {

                String token[] = s.split(";");
                switch (Integer.parseInt(token[2])) {
                    case 1:
                        token[2] = "Rojo";
                        break;
                    case 2:
                        token[2] = "Azul";
                        break;
                    case 3:
                        token[2] = "Amarillo";
                        break;
                }

                switch (token[0]) {

                    case "Pentagono":

                        Pentagono nuevoPentagono = new Pentagono(token[0], Integer.parseInt(token[1]), token[2], Double.parseDouble(token[3]));
                        figuras.add(nuevoPentagono);

                        break;

                    case "Circulo":

                        Circulo nuevoCirculo = new Circulo(token[0], Integer.parseInt(token[1]), token[2], Double.parseDouble(token[3]));
                        figuras.add(nuevoCirculo);

                        break;

                    case "Triangulo":

                        Triangulo nuevoTriangulo = new Triangulo(token[0], Integer.parseInt(token[1]), token[2], Double.parseDouble(token[3]), Double.parseDouble(token[4]), Double.parseDouble(token[5]));
                        figuras.add(nuevoTriangulo);

                        break;

                    case "Rectangulo":

                        Rectangulo nuevoRectangulo = new Rectangulo(token[0], Integer.parseInt(token[1]), token[2], Double.parseDouble(token[3]), Double.parseDouble(token[4]));
                        figuras.add(nuevoRectangulo);

                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }
}
