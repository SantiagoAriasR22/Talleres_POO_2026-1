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

    //getters
    public String getColor() {
        return color;
    }
    public String getTipoFig() {return tipoFig;}
    public int getId() {return id;}

    //setters
    public void setColor(String nuevoColor){this.color=nuevoColor; }

    //methods abstracts
    public abstract double doCalcularArea();
    public abstract double doCalcularPerimetro();
}
