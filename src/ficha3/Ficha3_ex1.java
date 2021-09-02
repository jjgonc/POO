package ficha3;

public class Ficha3_ex1 {
    private double x;
    private double y;
    private double raio;

    public Ficha3_ex1() {
        x = y = raio = 0;
    }

    public Ficha3_ex1 (double x, double y, double raio) {
        this.x = x;
        this.y = y;
        this.raio = raio;
    }


    public Ficha3_ex1 (Ficha3_ex1 obj) {
        this.x = obj.getX();
        this.y = obj.getY();
        this.raio = obj.getRaio();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public void alteraCentro(double x, double y) {
        this.x = x;
        this.y = y;
        /*
        ou entao tbm podia fazer:
        setX(x);
        setY(y);
         */
    }

    public double calculaArea () {
        return (Math.PI * Math.pow(this.raio, 2));
    }

    public double calculaPerimetro () {
        return Math.PI*2*this.raio;
    }

    public boolean equals (Object o) {
        if (this == o)
            return true;
        if (o == null || this.getClass() != o.getClass())
            return false;
        Ficha3_ex1 p = (Ficha3_ex1) o; //fazer o cast (dizer que é deste tipo)

        return (this.x == p.getX()
                && this.y == p.getY()
                && this.raio == p.getRaio());
    }

    public Ficha3_ex1 clone (){
        return new Ficha3_ex1(this);
    }

    public String toString() {
        return "Ficha3_ex1{" +
                "x=" + x +
                ", y=" + y +
                ", raio=" + raio +
                '}';
    }

}
