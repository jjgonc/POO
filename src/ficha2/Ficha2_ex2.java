package ficha2;

import java.util.Arrays;

public class Ficha2_ex2 {
 /*
            U1 U2 U3 U4 U5
Aluno1      [] [] [] [] []
Aluno2      [] [] [] [] []
Aluno3      [] [] [] [] []
Aluno4      [] [] [] [] []
Aluno5      [] [] [] [] []
*/
    public int atualizaArray (int aluno, int uc, int nota, int [] [] array) {
        array [aluno] [uc] = nota;
        return nota;
    }

    public int sum (int uc, int [] [] array) {
        int sum = 0;
        for (int i =0; i < 5; i++) {
            sum += array[i] [uc];
        }
        return sum;
    }

    public float mediaAluno (int [] [] array, int aluno) {
        float media = 0;
        int soma = 0;
        for (int i=0; i < 5; i++) {
            soma += array [aluno] [i];
        }
        media = soma/5;
        return media;
    }

    public float mediaUC (int [] [] array, int uc) {
        float media = 0;
        int soma = 0;
        for (int i=0; i < 5; i++) {
            soma += array [i] [uc];
        }
        media = soma/5;
        return media;
    }

    public int notaMaisAlta (int [] [] array) {
        int nota=0;
        int max = 0;
        for (int i=0; i < 5; i++) {
            for (int j=0; j<5; j++) {
                nota = array[i][j];
                if (nota > max) max = nota;
            }
        }
        return max;
    }

    public int notaMaisBaixa (int [] [] array) {
        int nota;  //por ex
        int min = Integer.MAX_VALUE;
        for (int al=0; al < 5; al++) {
            for (int j=0; j<5; j++) {
                nota = array[al][j];
                if (nota < min) min = nota;
            }
        }
        return min;
    }

    public static String biggerThan (int valorMin, int [] [] array) {
        int [] biggers = new int[25];
        int ind =0;
        for (int i=0; i<5; i++) {
            for(int j=0; j<=5; j++) {
                if (array [i] [j] > valorMin) biggers[ind++] = array[i] [j];
            }
        }
        int [] res = new int [ind];
        System.arraycopy(biggers,0,res,0,ind);
        return (Arrays.toString(res));
    }

    public static String notasAlunos (int [] [] array) {
        return (Arrays.deepToString(array));
    }

    public static int indexMaxUc (int [] [] array) {
        double maxMean = 0;
        int maxInd = 0;
        int soma = 0;
        double media = 0;
        for (int uc = 0; uc < 5; uc++) {
            soma = 0;
            for (int aluno= 0; aluno<5; aluno++) {
                soma += array[aluno] [uc];
            }
            media = soma/5;
            if (media > maxMean) maxInd = uc;
        }
        return maxInd;
    }
}










/*
public class Ficha2_ex3 {
    private LocalDate[] datas;
    private int ndatas;

    public Ficha2_ex3 () {
        datas = new LocalDate[10];
        ndatas = 0;
    }
    public void insereData (LocalDate d) {
        if (ndatas>10) {
            datas.ndatas = d;
            ndatas++;
        }
    }
    public LocalDate dataMaisProx (LocalDate d) {
        LocalDate res = datas [0];
        long dist = 999999999;
        for (int i = 0; i< ndatas; i++) {
            long dias d.until (datas[i], chronoUnit.Days);
            dias = Math.abs(dias);
            if (dias<dist) {
                res = datas[i];
                dist = dias;
            }
        }
    }
}



 */