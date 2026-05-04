package FigurasGeometricas;

public abstract class Figura {
    protected String tipoFig;
    protected int id;
    private String color;
    public Figura(String tipoFig, int id, String color){
        this.tipoFig=tipoFig;
        this.id = id;
        this.color = color;
    }
    //getter
    public String getColor() {
        return color;
    }
    public String getTipoFig() {return tipoFig;}
    public int getId() {return id;}
    //metodos abstractos
    public abstract double doCalcularArea();
    public abstract double doCalcularPerimetro();
}
