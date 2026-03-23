package FigurasGeometricas;

public class FiguraAux {

        String tipo;
        String color;
        double area;
        double perimetro;
        String id;

        //getter
    public String getColor() {
        return color;
    }
    public String getTipo() {
        return tipo; }

    public String getId() {
        return id; }

    public double getArea() {
        return area;
    }
        public FiguraAux(String tipo, String id, String color, double area, double perimetro) {
            this.tipo = tipo;
            this.id = id;
            this.color = color;
            this.area = area;
            this.perimetro = perimetro;
        }
    }

