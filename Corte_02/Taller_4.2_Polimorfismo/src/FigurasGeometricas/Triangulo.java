package FigurasGeometricas;


public class Triangulo extends Figura{
    protected double lado1;
    protected  double lado2;
    protected double lado3;
    public Triangulo(int id, String color, double lado1, double lado2, double lado3){
        super(id, color);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }
    double doCalcularArea(){
        double s=(lado1+lado2+lado3)/2;
        return Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
    }
    double doCalcularPerimetro(){
        return lado1 + lado2 + lado3;
    }
}
