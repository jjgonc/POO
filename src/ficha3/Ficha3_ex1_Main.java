package ficha3;

public class Ficha3_ex1_Main {
    public static void main (String [] args) {
        Ficha3_ex1 c = new Ficha3_ex1();
        c.setRaio(1);
        double p = c.calculaPerimetro();
        System.out.println("Perimetro: " +p);
        System.out.println(c);
        c.alteraCentro(1,1);
        System.out.println(c);
        double a = c.calculaArea();
        System.out.println("Area: " +a);

        //neste caso o equals que usamos é o que definimos, em vez do do java (poderiamos chamar myEquals para ver a diferença)
        Ficha3_ex1 c2 = c.clone();
        System.out.println("c == c ?? " +c.equals(c));  //apenas este daria true se fosse usadas as funçoes do java, mas nos redefinimos para resolver isto
        System.out.println("c == c2 ?? " +c.equals(c2));

        c2.setRaio(5);
        System.out.println("c == c2 ??" +c.equals(c2));

        c.setRaio(5);
        System.out.println("c == c2 ?? " +c.equals(c2));

    }
}
