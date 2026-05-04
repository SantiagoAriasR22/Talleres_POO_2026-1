package FigurasGeometricas;

public class Circulo extends Figura{
    protected double diametro;
    public Circulo(String tipoFig, int id, String color, double diametro){
        super(tipoFig, id, color);
        this.diametro = diametro;
    }
    @Override
    public double doCalcularArea() {
        return Math.PI * (diametro/2) * (diametro/2);
    }
    @Override
    public double doCalcularPerimetro() {
        return 2 * Math.PI * diametro;
    }
}
