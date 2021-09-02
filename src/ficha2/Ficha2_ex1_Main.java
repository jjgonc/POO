package ficha2;

import java.util.Arrays;
import java.util.Scanner;

public class Ficha2_ex1_Main {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Ficha2_ex1 f = new Ficha2_ex1();

        //alinea a
        System.out.println("Quantos valores a ler?");
        int ler = sc.nextInt();
        int [] a = new int [ler];
        System.out.println("Introduza " + ler + " inteiros");
        for (int i = 0; i<a.length; i++) {
            a[i] = sc.nextInt();
        }

        int min = f.minimo(a);
        System.out.println("O valor mínimo é: " +min);

        //alinea b
        System.out.println("Quantos valores a ler?");
        ler = sc.nextInt();
        a = new int[ler];
        System.out.println("Introduza " +ler+ " inteiros");
        for (int i=0; i<a.length; i++){
            a[i] = sc.nextInt();
        }
        System.out.println("Introduza os 2 indices");
        int inicio = sc.nextInt();
        int fim = sc.nextInt();

        int [] b = f.valoresEntre(a, inicio, fim);
        System.out.println("Valores entre esses indices: " +Arrays.toString(b));

        //alinea c
        //valores em comum entre o array a e o array do elementos entre os indices pretendidos
        System.out.println("Elementos comuns: " + Arrays.toString(f.comuns(a,b)));

    }
}
