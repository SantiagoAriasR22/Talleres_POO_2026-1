package FigurasGeometricas;

public class Rectangulo extends Figura{

    protected  double base;
    protected  double altura;

    public Rectangulo(String tipoFig, int id, String color, double base, double altura){
        super(tipoFig, id, color);
        this.base = base;
        this.altura = altura;
    }

    //setters
    public void setBase(double nuevaBase){this.base=nuevaBase; }

    public void setAltura(double nuevaAltura){this.altura=nuevaAltura; }

    //methods abstracts
    @Override
    public double doCalcularArea(){
        return base * altura;
    }

    @Override
    public double doCalcularPerimetro(){
        return 2 * (base + altura);
    }
}
