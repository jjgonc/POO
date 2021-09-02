package ficha3;

//aula 17-03-2021

import java.util.Arrays;

public class Triangulo {
    private Ponto p1;
    private Ponto p2;
    private Ponto p3;


    public Ponto getP1() {
        return p1;
    }

    public void setP1(Ponto p1) {
        this.p1 = p1;
    }

    public Ponto getP2() {
        return p2;
    }

    public void setP2(Ponto p2) {
        this.p2 = p2;
    }

    public Ponto getP3() {
        return p3;
    }

    public void setP3(Ponto p3) {
        this.p3 = p3;
    }

    public Triangulo () {
        this.p1 = new Ponto();
        this.p2 = new Ponto();
        this.p3 = new Ponto();
    }

    public Triangulo (Triangulo t) {
        this.p1 = t.getP1();
        this.p2 = t.getP2();
        this.p3 = t.getP3();
    }

    public Triangulo (Ponto p1, Ponto p2, Ponto p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Triangulo clone () {
        return new Triangulo(this);
    }

    public boolean equals (Object o) {
        if (o == this) return true;
        if (o == null || this.getClass() != o.getClass() ) return true;
        Triangulo t = (Triangulo) o;
        return (this.p1.equals(t.getP1()) || this.p1.equals(t.getP2()) || this.p1.equals(t.getP3())
                || this.p2.equals(t.getP1()) || this.p2.equals(t.getP2()) || this.p2.equals(t.getP3())
                || this.p3.equals(t.getP1()) || this.p3.equals(t.getP2()) || this.p3.equals(t.getP3()));
    }

    /*
    Area of ΔABC = 1/2 {(x1 y2  + x2 y3  + x3 y1 ) −(x2 y1 + x3 y2  + x1 y3 )}
    Taken from:
    http://www.brainkart.com/article/Area-of-a-Triangle_39390/
     */
    public double area () {
        double area = Math.abs(
                (double) (1/2) * (
                        (p1.getX()*p2.getY() + p2.getX()*p3.getY() + p3.getX()*p1.getY()))
                -
                        (p2.getX()*p1.getY() + p3.getY()* p2.getY() + p1.getX()*p3.getY())
        );
        return area;
    }

    public double perimetro () {
        double p = p1.distancia(p2) + p2.distancia(p3) + p3.distancia(p1);
        return p;
    }

    /*
    Método que calcula a altura do triângulo, definido como sendo a distância no eixo dos y
    entre o ponto com menor coordenada em y e o ponto com maior coordenada
     */
    public double altura () {
        double h[] = new double[3];
        h[0] = p1.getY();
        h[2] = p2.getY();
        h[3] = p3.getY();
        Arrays.sort(h);
        return Math.abs(h[2] - h[0]);
    }


    public String toString() {
        return "Triangulo{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                '}';
    }
}
