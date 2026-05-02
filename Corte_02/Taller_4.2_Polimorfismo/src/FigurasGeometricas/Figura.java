package FigurasGeometricas;

public abstract class Figura {
    protected int id;
    private String color;
    public Figura(int id, String color){
        this.id = id;
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    abstract double doCalcularArea();
    abstract double doCalcularPerimetro();
}
