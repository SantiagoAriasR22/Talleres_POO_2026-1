package FigGeom;

public class Rectangulo {

	protected double altura;
	protected double base;
	protected String id;
	private String color;

	public Rectangulo(String id, double altura, double base, String color) {
		this.altura = altura;
		this.base = base;
		this.color = color;
		this.id=id;
	}

	//getters
	public String getColor() {
		return color;
	}

	public double getAltura() {
		return altura;
	}

	public double getBase() {
		return base;
	}

	public String getID(){ return id; }

	//setters
	public void setAltura(double altura) {
		this.altura = altura;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public void setColor(String color){ this.color=color; }

	//methods
	public double doCalcularPerimetro() {
		return (2 * altura) + (2 * base);
	}

	public double doCalcularArea() {
		return base * altura;
	}
}

