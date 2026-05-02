package FigurasGeometricas;

public class Pentagono extends Figura{
    protected double lados;
    public Pentagono(int id, String color, double lados){
        super(id, color);
        this.lados = lados;
    }
    double doCalcularArea(){
        return ((5*lados)*lados/2*Math.tan(36))/2;
    }
    double doCalcularPerimetro(){
        return lados * 5;
    }
}
