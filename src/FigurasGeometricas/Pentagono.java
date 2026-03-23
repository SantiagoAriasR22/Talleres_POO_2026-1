package FigurasGeometricas;

public class Pentagono {

	protected double lado;
	protected String id;
	private String color;

	public Pentagono(String id, double lado, String color) {
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
		return lado*5;
	}
	
	public double doCalcularArea() {
		return (lado/(2*Math.tan(Math.PI/5.0))*5*lado)/2.0;	
	}
	
	
}
