package FigurasGeometricas;

public class Circulo extends Figura{
    protected double diametro;
    public Circulo(int id, String color, double diametro){
        super(id, color);
        this.diametro = diametro;
    }
    @Override
    double doCalcularArea() {
        return Math.PI * diametro * diametro;
    }
    @Override
    double doCalcularPerimetro() {
        return 2 * Math.PI * diametro;
    }
}
