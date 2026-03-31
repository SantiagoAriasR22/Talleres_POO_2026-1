package FigurasGeometricas;

public class Cuadrado {

	protected double lado;
	protected String id;
	private String color;
	
	public Cuadrado(String id, double lado, String color) {
		this.lado=lado;
		this.id=id;
		this.color=color;
	}

	
	//getters
	public String getColor() {
		return color;
	}
	
	public double getLado() {
		return lado;
	}

	public String getID(){ return id; }
	
	//setters
	public void setLado(double lado) {
		this.lado=lado;
	}

	public void setColor(String color){ this.color=color; }

	//methods
	public double doCalcularPerimetro() {
		return 4*lado;
	}
	
	public double doCalcularArea() {
		return lado*lado;
	}
}
