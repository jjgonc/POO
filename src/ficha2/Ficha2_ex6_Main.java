package ficha2;

import java.util.Scanner;

public class Ficha2_ex6_Main {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        Ficha2_ex6 f = new Ficha2_ex6();
        System.out.println("Qual o numero de linhas e colunas da matriz (matriz quadrada)?");
        int size = sc.nextInt();

        //criar as matrizes:
        int [] [] mat = new int [size] [size];
        int x = 1;
        for (int i = 0; i<size; i++) {
            for (int j=0; j<size; j++) {
                mat[i][j] = 1;
            }
        }


        //criar as outra matriz:
        int [] [] mat2 = new int [size] [size];
        int y = 1;
        for (int k = 0; k<size; k++) {
            for (int l=0; l<size; l++) {
                mat2[k][l] = y;
            }
        }


        //alinea a era so criar as matrizes (feita!)


        //alinea b (alterar acima onde defini ambas as matrizes os valores das mesmas para testar com novos valores)
        String res = f.matrix_Sum (mat, mat2);
        System.out.println(res);

        //alinea c
        boolean res_c = f.isEq_Matrix(mat, mat2);
        if (res_c==true) System.out.println("São iguais");
        else System.out.println("nao sao iguais");

        //alinea d
        String res_d = f.oppositeMat(mat);
        System.out.println(res_d);
    }
}
