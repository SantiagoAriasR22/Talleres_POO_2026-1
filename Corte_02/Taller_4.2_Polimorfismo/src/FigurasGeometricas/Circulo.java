package FigurasGeometricas;

public class Circulo extends Figura{

    protected double diametro;

    public Circulo(String tipoFig, int id, String color, double diametro){
        super(tipoFig, id, color);
        this.diametro = diametro;
    }

    //setters
    public void setDiametro(double nuevoDiametro){this.diametro=nuevoDiametro; }

    //methods abstracts
    @Override
    public double doCalcularArea() {
        return Math.PI * Math.pow(diametro/2, 2);
    }

    @Override
    public double doCalcularPerimetro() {
        return   Math.PI * diametro;
    }
}
