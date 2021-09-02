package ficha1;

import java.util.Scanner;

public class ficha1_exerciciosI_Main {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        ficha1_exerciciosI f = new ficha1_exerciciosI();

        System.out.println("Qual o dia?");
        int dia = s.nextInt();
        System.out.println("Qual o mes?");
        int mes = s.nextInt();
        System.out.println("Qual o ano?");
        int ano = s.nextInt();

        int res = f.diaDaSemana(dia, mes, ano);
        System.out.println("passaram " +res+ " dias");
    }

}
