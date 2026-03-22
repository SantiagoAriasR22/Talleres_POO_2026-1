package FigGeom;
import java.math.*;

	public class Circulo {

	protected double diametro;
	protected String id;
	private String color;
	
	public Circulo(String id, double diametro, String color) {
		this.diametro=diametro;
		this.id=id;
		this.color=color;
	}
	
	//getters
	public String getColor() {
		return color;
	}

	public String getID(){ return id; }
	
	//setters
	public void setDiametro(double diametro) { this.diametro=diametro; }

	public void setColor(String color){ this.color=color; }

	//methods
	public double doCalcularPerimetro() {
		return Math.PI*diametro;
	}
	
	public double doCalcularArea() {
		return Math.PI*Math.pow(diametro/2.0, 2);
	}
}
