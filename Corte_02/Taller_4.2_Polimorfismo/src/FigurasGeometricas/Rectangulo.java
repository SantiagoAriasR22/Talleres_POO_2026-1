package FigurasGeometricas;

public class Rectangulo extends Figura{
    protected  double base;
    protected  double altura;
    public Rectangulo(int id, String color, double base, double altura){
        super(id, color);
        this.base = base;
        this.altura = altura;
    }
    double doCalcularArea(){
        return base * altura;
    }
    double doCalcularPerimetro(){
        return 2 * (base + altura);
    }
}
