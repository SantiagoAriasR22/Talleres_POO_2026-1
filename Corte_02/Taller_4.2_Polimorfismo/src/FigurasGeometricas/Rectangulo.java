package FigurasGeometricas;

public class Rectangulo extends Figura{
    protected  double base;
    protected  double altura;
    public Rectangulo(String tipoFig, int id, String color, double base, double altura){
        super(tipoFig, id, color);
        this.base = base;
        this.altura = altura;
    }
    @Override
    public double doCalcularArea(){
        return base * altura;
    }
    @Override
    public double doCalcularPerimetro(){
        return 2 * (base + altura);
    }
}
