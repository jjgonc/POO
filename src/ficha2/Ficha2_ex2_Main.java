package ficha2;

import java.util.Scanner;

 /*
 ARRAY DEFAULT:

             U1   U2   U3   U4   U5
Aluno1      [11] [12] [13] [14] [15]
Aluno2      [21] [22] [23] [24] [25]
Aluno3      [31] [32] [33] [34] [35]
Aluno4      [41] [42] [43] [44] [45]
Aluno5      [51] [52] [53] [54] [55]
*/


public class Ficha2_ex2_Main {

    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        Ficha2_ex2 f = new Ficha2_ex2();
        int [] [] array = new int [5] [5];
/*
        //Recolher os 5 alunos
        for (int al=0; al<5; al++) {
            for (int uc=0; uc<5; uc++) {
                System.out.println("Digite a nota do aluno " +(al+1)+ " à UC "+(uc+1));
                int nota = sc.nextInt();
                array [al] [uc] = nota;
            }
        }
*/
        //usar default em que a nota tem como 1º o numero do aluno e o 2º a uc (aluno 1 e uc 2 ==> nota 12, por ex)
        for (int linha=0; linha<5; linha++) {
            for (int coluna=0; coluna<5; coluna++) {
                array[linha] [coluna] = (linha+1)*10 + (coluna+1);
            }
        }

/*
        //alinea a
        System.out.println("Digite o nº do aluno que pretende encontrar:");
        int al_1 = sc.nextInt();
        System.out.println("Digite o nº da UC que pretende encontrar:");
        int uc_1 = sc.nextInt();
        System.out.println("Qual a nova nota?");
        int nota_1 = sc.nextInt();
        int nota_before = array[al_1-1] [uc_1-1];
        int res_1 = f.atualizaArray(al_1-1, uc_1-1, nota_1, array); //fazer -1 ao aluno e à UC pq vai de 0 ate 4
        System.out.println("A nota do aluno "+al_1+ " à UC "+uc_1+ " passou de " +nota_before+ " para " +res_1);

        System.out.println();

        //alinea b
        System.out.println("Qual a unidade curricular que pretende saber a soma das notas?");
        int uc_2 = sc.nextInt();
        int sum_2 = f.sum(uc_2-1, array);
        System.out.println("A soma das notas à UC " +uc_2+ " é de " +sum_2);

        System.out.println();

        //alinea c
        System.out.println("Qual a aluno que pretende saber a media das notas?");
        int al_3 = sc.nextInt();
        float mean_3 = f.mediaAluno(array, al_3-1);
        System.out.println("A media do aluno " +al_3+ " é de " +mean_3);

        System.out.println();

        //alinea d
        System.out.println("Qual a UC que pretende saber a media das notas?");
        int uc_4 = sc.nextInt();
        float meanAluno_4 = f.mediaUC(array, uc_4-1);
        System.out.println("A média à UC" +uc_4+ " é de " +meanAluno_4);

        System.out.println();

        //alinea e
        int notaMaisAlta = f.notaMaisAlta(array);
        System.out.println("A nota mais alta a todas as UC's de todos os alunos é: " +notaMaisAlta);

        System.out.println();

        //alinea f
        int notaMaisBaixa = f.notaMaisBaixa(array);
        System.out.println("A nota mais baixa a todas as UC's de todos os alunos é: " +notaMaisBaixa);

        System.out.println();

        //alinea g
        System.out.println("Digite a nota que pretende saber as maiores que essa:");
        int nota_7 = sc.nextInt();
        String res = f.biggerThan(nota_7, array);
        System.out.println("Grades bigger than " + nota_7 + ": " + res);
*/
        System.out.println();

        //alinea h
        String notasAlunos_8 = f.notasAlunos(array);
        System.out.println("Notas de todos os alunos: " +notasAlunos_8);

        System.out.println();

        //alinea i
        int maior_media_uc = f.indexMaxUc(array);
        System.out.println("A UC com a maior média é a UC nº " +maior_media_uc);
    }
}
