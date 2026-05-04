package FigurasGeometricas;

public class Pentagono extends Figura{
    protected double lados;
    public Pentagono(String tipoFig, int id, String color, double lados){
        super(tipoFig, id, color);
        this.lados = lados;
    }
    @Override
    public double doCalcularArea(){
        return ((5*lados)*lados/2*Math.tan(36))/2;
    }
    @Override
    public double doCalcularPerimetro(){
        return lados * 5;
    }
}
