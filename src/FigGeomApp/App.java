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

		int menu;

		do{
			menu=menuPrincipal();

			switch (menu){

				case 1:
					int figura=menuFigura();

					System.out.println("Ingrese la ID de la figura que quiere mostrar");
					String idBuscada=sc.next();

					int index=buscarID(idBuscada, figura);

					if(index==-1){
						System.out.println("Figura no encontrada");
						break;
					}

					mostrarAreayPerimetro(index, figura);

					break;

				case 2:

					int figura2=menuFigura();

					System.out.println("Ingrese la ID de la figura que quiere modificar");
					String idBuscada2=sc.next();

					int index2=buscarID(idBuscada2, figura2);

					if(index2==-1){
						System.out.println("Figura no encontrada");
						break;
					}

					switch(figura2){
						case 1: actualizarCirculo(index2); break;
						case 2: actualizarCuadrado(index2); break;
						case 3: actualizarRectangulo(index2); break;
						case 4: actualizarPentagono(index2); break;
						case 5: actualizarTriangulo(index2); break;
					}



			}
		}while(menu!=4);

	}

	static int buscarID(String idBuscada, int figura) {

		switch (figura) {
			case 1:

				for (int i = 0; i < circle.size(); i++) {
					if (circle.get(i).getID().equals(idBuscada)) {
						return i;
                    }
				}
				break;

			case 2:

				for (int i = 0; i < square.size(); i++) {
					if (square.get(i).getID().equals(idBuscada)) {
						return i;
					}
				}
				break;

			case 3:

				for (int i = 0; i < rectangle.size(); i++) {
					if (rectangle.get(i).getID().equals(idBuscada)) {
						return i;
					}
				}
				break;

			case 4:

				for (int i = 0; i < pentagon.size(); i++) {
					if (pentagon.get(i).getID().equals(idBuscada)) {
						return i;
					}
				}
				break;

			case 5:

				for (int i = 0; i < triangle.size(); i++) {
					if (triangle.get(i).getID().equals(idBuscada)) {
						return i;
					}
				}
				break;
		}
		return -1;
	}

	static void actualizarCirculo(int index2){

		int opcion;

		do {
			System.out.println("Ingrese el atributo que desea modificar");
			System.out.println("1. Diametro");
			System.out.println("2. Color");
			System.out.println("3. Volver al menu principal");
			opcion=sc.nextInt();

			if(opcion==1){
				System.out.println("Ingrese el valor del nuevo diametro");
				double nuevoDiametro=sc.nextDouble();
				nuevoDiametro=validarAtributos(nuevoDiametro);
				circle.get(index2).setDiametro(nuevoDiametro);
				System.out.println("Se actualizo el perimetro correctamente");
			}
			else if(opcion==2){
				System.out.println("Ingrese el nuevo color");
				System.out.println("Debe ser amarillo, azul o rojo (todo en minuscula)");
				String nuevoColor=sc.next();
				nuevoColor=validarColor(nuevoColor);
				circle.get(index2).setColor(nuevoColor);
				System.out.println("Se actualizo el color correctamente");
			}

		}while(opcion!=3);
	}

	static void actualizarCuadrado(int index2){

		int opcion;

		do {
			System.out.println("Ingrese el atributo que desea modificar");
			System.out.println("1. Lados");
			System.out.println("2. Color");
			System.out.println("3. Volver al menu principal");
			opcion=sc.nextInt();

			if(opcion==1){
				System.out.println("Ingrese el valor nuevo de los lados");
				double nuevosLados=sc.nextDouble();
				nuevosLados=validarAtributos(nuevosLados);
				square.get(index2).setLado(nuevosLados);
				System.out.println("Se actualizaron los lados correctamente");
			}
			else if(opcion==2) {
				System.out.println("Ingrese el nuevo color");
				System.out.println("Debe ser amarillo, azul o rojo (todo en minuscula)");
				String nuevoColor=sc.next();
				nuevoColor=validarColor(nuevoColor);
				square.get(index2).setColor(nuevoColor);
				System.out.println("Se actualizo el color correctamente");
			}

		}while(opcion!=3);
	}

	static void actualizarRectangulo(int index2){

		int opcion;

		do {
			System.out.println("Ingrese el atributo que desea modificar");
			System.out.println("1. Altura");
			System.out.println("2. Base");
			System.out.println("3. Color");
			System.out.println("4. Volver al menu principal");
			opcion=sc.nextInt();

			switch (opcion){

				case 1:
					System.out.println("Ingrese el valor nuevo de la altura");
					double nuevaAltura=sc.nextDouble();
					nuevaAltura=validarAtributos(nuevaAltura);
					rectangle.get(index2).setAltura(nuevaAltura);
					System.out.println("Se actualizo la altura correctamente");
					break;

				case 2:
					System.out.println("Ingrese el valor nuevo de la base");
					double nuevaBase=sc.nextDouble();
					nuevaBase=validarAtributos(nuevaBase);
					rectangle.get(index2).setBase(nuevaBase);
					System.out.println("Se actualizaro la base correctamente");
					break;

				case 3:
					System.out.println("Ingrese el nuevo color");
					System.out.println("Debe ser amarillo, azul o rojo (todo en minuscula)");
					String nuevoColor=sc.next();
					nuevoColor=validarColor(nuevoColor);
					rectangle.get(index2).setColor(nuevoColor);
					System.out.println("Se actualizo el color correctamente");

			}

		}while(opcion!=4);

	}

	static void actualizarPentagono(int index2){

		int opcion;

		do {
			System.out.println("Ingrese el atributo que desea modificar");
			System.out.println("1. Lados");
			System.out.println("2. Color");
			System.out.println("3. Volver al menu principal");
			opcion=sc.nextInt();

			if(opcion==1){
				System.out.println("Ingrese el nuevo valor de los lados");
				double nuevosLados=sc.nextDouble();
				nuevosLados=validarAtributos(nuevosLados);
				pentagon.get(index2).setLado(nuevosLados);
				System.out.println("Se actualizaron los lados correctamente");
			}
			else if(opcion==2) {
				System.out.println("Ingrese el nuevo color");
				System.out.println("Debe ser amarillo, azul o rojo (todo en minuscula)");
				String nuevoColor=sc.next();
				nuevoColor=validarColor(nuevoColor);
				pentagon.get(index2).setColor(nuevoColor);
				System.out.println("Se actualizo el color correctamente");
			}

		}while(opcion!=3);
	}

	static void actualizarTriangulo(int index2){

		int opcion;

		do{
			System.out.println("Ingrese el atributo que desea modificar");
			System.out.println("1. Lado1");
			System.out.println("2. Lado2");
			System.out.println("3. Lado3");
			System.out.println("4. Color");
			System.out.println("5. Volver al menu principal");
			opcion=sc.nextInt();

			switch(opcion){

				case 1:
					System.out.println("Ingrese el nuevo valor del lado1");
					double nuevoLado1=sc.nextDouble();
					nuevoLado1=validarAtributos(nuevoLado1);
					triangle.get(index2).setLado1(nuevoLado1);
					System.out.println("Se actualizo el lado1 correctamente");
					break;

				case 2:
					System.out.println("Ingrese el nuevo valor del lado2");
					double nuevoLado2=sc.nextDouble();
					nuevoLado2=validarAtributos(nuevoLado2);
					triangle.get(index2).setLado2(nuevoLado2);
					System.out.println("Se actualizo el lado2 correctamente");
					break;

				case 3:
					System.out.println("Ingrese el nuevo valor del lado3");
					double nuevoLado3=sc.nextDouble();
					nuevoLado3=validarAtributos(nuevoLado3);
					triangle.get(index2).setLado3(nuevoLado3);
					System.out.println("Se actualizo el lado3 correctamente");
					break;

				case 4:
					System.out.println("Ingrese el nuevo color");
					System.out.println("Debe ser amarillo, azul o rojo (todo en minuscula)");
					String nuevoColor=sc.next();
					nuevoColor=validarColor(nuevoColor);
					triangle.get(index2).setColor(nuevoColor);
					System.out.println("Se actualizo el color correctamente");
			}
		}while(opcion!=5);
	}

	static double validarAtributos(double modificador){

		while(modificador<=0){
			System.out.println("El valor ingresado debe ser mayor a 0");
			modificador=sc.nextDouble();
		}

		return modificador;

	}

	static String validarColor(String modificadorColor){

		while(!modificadorColor.equalsIgnoreCase("amarillo")&& !modificadorColor.equalsIgnoreCase("azul") && !modificadorColor.equalsIgnoreCase("rojo")){
			System.out.println("El color debe ser amarillo, azul o rojo (todo en minuscula");
			modificadorColor=sc.next();
		}

		return modificadorColor;
	}

	static void mostrarAreayPerimetro(int index, int figura){

		switch(figura){
			case 1:
				System.out.println("Tipo de figura: Circulo");
				System.out.printf("Area: %.2f\n", circle.get(index).doCalcularArea());
				System.out.printf("Perimetro: %.2f\n", circle.get(index).doCalcularPerimetro());
				break;

			case 2:
				System.out.println("Tipo de figura: Cuadrado");
				System.out.printf("Area: %.2f\n", square.get(index).doCalcularArea());
				System.out.printf("Perimetro: %.2f\n", square.get(index).doCalcularPerimetro());
				break;

			case 3:
				System.out.println("Tipo de figura: Rectangulo");
				System.out.printf("Area: %.2f\n", rectangle.get(index).doCalcularArea());
				System.out.printf("Perimetro: %.2f\n", rectangle.get(index).doCalcularPerimetro());
				break;

			case 4:
				System.out.println("Tipo de figura: Pentagono");
				System.out.printf("Area: %.2f\n", pentagon.get(index).doCalcularArea());
				System.out.printf("Perimetro: %.2f\n", pentagon.get(index).doCalcularPerimetro());
				break;

			case 5:
				System.out.println("Tipo de figura: Triangulo");
				System.out.printf("Area: %.2f\n", triangle.get(index).doCalcularArea());
				System.out.printf("Perimetro: %.2f\n", triangle.get(index).doCalcularPerimetro());
				break;
		}
	}

	static int menuFigura(){
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

		return figura;
	}


	static int menuPrincipal () {

		int opcion;
		System.out.println("=========MENU=========");
		do {
			System.out.println("1. Mostrar area y perimetro de una figura");
			System.out.println("2. Actualizar datos de una figura");
			System.out.println("3. Consultar por tipo de figura u organizacion");
			System.out.println("4. Salir");
			opcion = sc.nextInt();
		}
		while (opcion<0 || opcion>4);

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
