package App;


import FigurasGeometricas.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class App {
    static ArrayList<Figura> figuras = new ArrayList<>();

    public static void main(String[] args) {
        App rf = new App();
        rf.begin();
        for(Figura f : figuras)
        {
            //if()
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
                    case "Cuadrado":

                        Cuadrado nuevoCuadrado = new Cuadrado(Integer.parseInt(token[1]), token[2], Double.parseDouble(token[3]));
                        figuras.add(nuevoCuadrado);

                        break;

                    case "Pentagono":

                        Pentagono nuevoPentagono = new Pentagono(Integer.parseInt(token[1]), token[2], Double.parseDouble(token[3]));
                        figuras.add(nuevoPentagono);

                        break;

                    case "Circulo":

                        Circulo nuevoCirculo = new Circulo(Integer.parseInt(token[1]), token[2], Double.parseDouble(token[3]));
                        figuras.add(nuevoCirculo);

                        break;

                    case "Triangulo":

                        Triangulo nuevoTriangulo = new Triangulo(Integer.parseInt(token[1]), token[2], Double.parseDouble(token[3]), Double.parseDouble(token[4]), Double.parseDouble(token[5]));
                        figuras.add(nuevoTriangulo);

                        break;

                    case "Rectangulo":

                        Rectangulo nuevoRectangulo = new Rectangulo(Integer.parseInt(token[1]), token[2], Double.parseDouble(token[3]), Double.parseDouble(token[4]));
                        figuras.add(nuevoRectangulo);

                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }
}