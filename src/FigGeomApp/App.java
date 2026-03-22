package FigGeomApp;
import java.util.ArrayList;
import FigGeom.*;


import java.io.*;
import java.util.Scanner;



public class App {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Circulo> circle;
	static ArrayList<Cuadrado> square;
	static ArrayList<Rectangulo> rectangle;
	static ArrayList<Pentagono> pentagon;
	static ArrayList<Triangulo> triangle;

	public App() {
		circle = new ArrayList<Circulo>();
		square = new ArrayList<Cuadrado>();
		rectangle = new ArrayList<Rectangulo>();
		pentagon = new ArrayList<Pentagono>();
		triangle = new ArrayList<Triangulo>();
	}

	public static void main(String[] args) {

		App rf = new App();
		rf.begin();

		switch (menuPrincipal()) {

			case 1:
				int figura;

				System.out.println("Ingresar la figura que desea mostrar");

				do{
					System.out.println("1. Circulo");
					System.out.println("2. Cuadrado");
					System.out.println("3. Rectangulo");
					System.out.println("4. Pentagono");
					System.out.println("5. Triangulo");
					figura=sc.nextInt();
				}while(figura<0 || figura>5);

				System.out.println("Ingrese la ID de la figura que desea mostrar");
				String idBuscada = sc.next();

				int i=buscarID(idBuscada, figura);
				if(i==-1){
					System.out.println("El ID ingresado es inexistente");
				}
				else {
					switch(figura){
						case 1:
							System.out.println("Tipo de figura: Circulo");
							System.out.printf("Area: %.2f\n", circle.get(i).doCalcularArea());
							System.out.printf("Perimetro: %.2f\n", circle.get(i).doCalcularPerimetro());
							break;

						case 2:
							System.out.println("Tipo de figura: Cuadrado");
							System.out.printf("Area: %.2f\n", square.get(i).doCalcularArea());
							System.out.printf("Perimetro: %.2f\n", square.get(i).doCalcularPerimetro());
							break;

						case 3:
							System.out.println("Tipo de figura: Rectangulo");
							System.out.printf("Area: %.2f\n", rectangle.get(i).doCalcularArea());
							System.out.printf("Perimetro: %.2f\n", rectangle.get(i).doCalcularPerimetro());
							break;

						case 4:
							System.out.println("Tipo de figura: Pentagono");
							System.out.printf("Area: %.2f\n", pentagon.get(i).doCalcularArea());
							System.out.printf("Perimetro: %.2f\n", pentagon.get(i).doCalcularPerimetro());
							break;

						case 5:
							System.out.println("Tipo de figura: Triangulo");
							System.out.printf("Area: %.2f\n", triangle.get(i).doCalcularArea());
							System.out.printf("Perimetro: %.2f\n", triangle.get(i).doCalcularPerimetro());
							break;
					}
				}

				break;

		}


	}

	static int buscarID(String idBuscada, int figura) {

		switch (figura) {
			case 1:

				for (int i = 0; i < circle.size(); i++) {
					if (circle.get(i).getID().equals(idBuscada)) {
						return i;
                    }

				}
			case 2:

				for (int i = 0; i < square.size(); i++) {
					if (square.get(i).getID().equals(idBuscada)) {
						return i;
					}

				}
			case 3:

				for (int i = 0; i < rectangle.size(); i++) {
					if (rectangle.get(i).getID().equals(idBuscada)) {
						return i;
					}


				}
			case 4:

				for (int i = 0; i < pentagon.size(); i++) {
					if (pentagon.get(i).getID().equals(idBuscada)) {
						return i;
					}


				}
			case 5:

				for (int i = 0; i < triangle.size(); i++) {
					if (triangle.get(i).getID().equals(idBuscada)) {
						return i;
					}

				}

		}
		return -1;
	}

		static int menuPrincipal () {
			int opcion = 0;
			System.out.println("=========MENU=========");
			do {
				System.out.println("1. Mostrar area y perimetro de una figura");
				System.out.println("2. Actualizar datos de una figura");
				System.out.println("3. Consultar por tipo de figura u organizacion");
				System.out.println("4. Salir");
				opcion = sc.nextInt();
			}
			while (opcion < 0 || opcion > 4);

			return opcion;

		}

		void begin () {

			File in = new File("data\\data.csv");

			try {

				BufferedReader br = new BufferedReader(new FileReader(in));
				String s;

				while ((s = br.readLine()) != null) {

					String token[] = s.split(",");
					String token2[] = token[2].split("-");

					switch (token[1]) {
						case "cuadrado":

							Cuadrado nuevoCuadrado = new Cuadrado(token[0], Double.parseDouble(token2[0]), token[3]);
							square.add(nuevoCuadrado);

							break;

						case "pentagono":

							Pentagono nuevoPentagono = new Pentagono(token[0], Double.parseDouble(token2[0]), token[3]);
							pentagon.add(nuevoPentagono);

							break;

						case "circulo":

							Circulo nuevoCirculo = new Circulo(token[0], Double.parseDouble(token[2]), token[3]);
							circle.add(nuevoCirculo);

							break;

						case "triangulo":

							Triangulo nuevoTriangulo = new Triangulo(token[0], Double.parseDouble(token2[0]), Double.parseDouble(token2[1]), Double.parseDouble(token2[2]), token[3]);
							triangle.add(nuevoTriangulo);

							break;

						case "rectangulo":

							Rectangulo nuevoRectangulo = new Rectangulo(token[0], Double.parseDouble(token2[0]), Double.parseDouble(token2[1]), token[3]);
							rectangle.add(nuevoRectangulo);

					}
				}

			} catch (Exception e) {
				System.out.println("Error: " + e);
			}
		}
	}
