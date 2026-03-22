package FigGeom;
import java.math.*;

public class Triangulo {

	protected double lado1;
	protected double lado2;
	protected double lado3;
	protected String id;
	private String color;
	
	public Triangulo(String id, double lado1, double lado2, double lado3, String color) {
		this.lado1=lado1;
		this.lado2=lado2;
		this.lado3=lado3;
		this.id=id;
		this.color=color;
	}
	
	//getters
	public String getColor() {
		return color;
	}
	
	public double getLado1() {
		return lado1;
	}
	
	public double getLado2() {
		return lado2;
	}
	
	public double getLado3() {
		return lado3;
	}

	public String getID(){ return id; }
	
	//setters
	public void setLado1(double lado1) {
		this.lado1=lado1;
	}
	
	public void setLado2(double lado2) {
		this.lado2=lado2;
	}
	
	public void setLado3(double lado3) {
		this.lado3=lado3;
	}

	public void setColor(String color){ this.color=color; }

	//methods
	public double doCalcularPerimetro() {
		return lado1+lado2+lado3;
	}

	public double doCalcularArea() {
		
		double s=(lado1+lado2+lado3)/2.0;
		
		return Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
		
	}
}
