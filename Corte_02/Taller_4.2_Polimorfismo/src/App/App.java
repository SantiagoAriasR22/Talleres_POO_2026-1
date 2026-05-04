package App;


import FigurasGeometricas.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<Figura> figuras = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        App rf = new App();
        rf.begin();


        switch(mainMenu()){
            case 1: break;
            case 2: break;
            case 3:
                for(Figura f : figuras)
                {
                    System.out.println("Tipo de figura : "+f.getTipoFig()+" ID: "+f.getId());
                    System.out.println("El color es : "+f.getColor());
                    if(f.getTipoFig().equals("Triangulo") && Double.isNaN(f.doCalcularArea())) {
                        System.out.println("El triangulo no puede ser construido geometricamente");
                    }
                    else {
                        System.out.println("Su area es : " + f.doCalcularArea());
                        System.out.println("Su perimetro es : " + f.doCalcularPerimetro());
                    }
                }   break;
            case 4: break;
            case 5: break;
        }




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
    public static int mainMenu(){
        int opcion;
        do{
            System.out.println("1. Buscar figura por ID");
            System.out.println("2. Cambiar datos de figura por ID");
            System.out.println("3. Mostrar todas las figuras");
            System.out.println("4. Mostrar figuras inexistentes");
            System.out.println("5. Mostrar un tipo de figura");
            System.out.println("6. Salir");
            opcion=sc.nextInt();
        }while(opcion>6 || opcion<1);
        return opcion;
    }
}