package FigurasGeometricas;

public class Cuadrado extends Figura{
    protected double lado;
    public Cuadrado(int id, String color, double lado){
        super(id, color);
        this.lado = lado;
    }
    double doCalcularArea(){
        return lado * lado;
    }
    double doCalcularPerimetro(){
        return 4 * lado;
    }
}
