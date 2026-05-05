package FigurasGeometricas;

public class Triangulo extends Figura{

    protected double lado1;
    protected  double lado2;
    protected double lado3;

    public Triangulo(String tipoFig, int id, String color, double lado1, double lado2, double lado3){
        super(tipoFig, id, color);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    //setters
    public void setLado1(double nuevoLado1){this.lado1=nuevoLado1; }

    public void setLado2(double nuevoLado2){this.lado2=nuevoLado2; }

    public void setLado3(double nuevoLado3){this.lado3=nuevoLado3; }

    //methods abstracts
    @Override
    public double doCalcularArea(){
        double s=(lado1+lado2+lado3)/2;
        return Math.sqrt(s*(s-lado1)*(s-lado2)*(s-lado3));
    }

    @Override
    public double doCalcularPerimetro(){
        return lado1 + lado2 + lado3;
    }
}
