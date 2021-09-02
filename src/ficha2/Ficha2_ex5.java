package ficha2;

import java.util.Arrays;

public class Ficha2_ex5 {
    public static String naoRepetidos (String [] arr) {
        String [] restr = new String [arr.length];    //criar um array restr com o tamanho igual ao array chamado array
        Arrays.fill(restr,"\0");    //inicializar o array novo a null
        restr[0] = arr[0];
        int index = 1;
        for (int i=1; i<arr.length; i++) {
            boolean found = false;
            for (int j=0; !(restr[j].equals("\0")) && found==false; j++) {
                if (arr[i].equals(restr[j])) {
                    found = true;
                }
            }
            if (found==false) {
                restr[index++] = arr[i];
            }
        }
        String[] res = new String[index];
        System.arraycopy(restr, 0, res, 0, index);
        return (Arrays.toString(res));
    }

    public static String biggest (String [] arr) {
        String biggest = arr[0];    //a maior inicializamos como a primeira string que passamos, caso haja uma maior, entao trocamos
        for (int i=0; i<arr.length; i++) {
            if (arr[i].length() > biggest.length()) {
                biggest = arr[i];
            }
        }
        return ("Biggest string inserted is: " +biggest);
    }



    public static String moreThanOnce (String [] arr) {
        String [] res = new String [arr.length];
        int ind = 0;
        for (int i=1; i<arr.length; i++) {
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (arr[i].equals(arr[j])) {
                    for (int k = 0; k < ind && !found; k++) {
                        if (arr[i].equals(res[k])) found = true;
                    }
                    if (!found) {
                        res[ind++] = arr[i];
                    }
                }
            }
        }
        String[] retornar = new String[ind];
        System.arraycopy(res,0, retornar, 0, ind);
        return (Arrays.toString(retornar));
    }


    public static int howMany (String [] arr, String testStr) {
        int reps = 0;
        for (int i=0; i<arr.length; i++) {
            if (testStr.equals(arr[i])) reps++;
        }
        return reps;
    }

/*
versao que estava a fazer (complicada e desnecessaria xD)
    public int howManyReps (String [] arr, String [] test) {
        int reps = 0;
        int indTeste = 0;
        boolean saiDoCiclo = false;
        for (int i=0; i<arr.length; i++) {
            saiDoCiclo = false;
            indTeste = 0;
            if (arr[i] == test[0]) indTeste = i;
            for (int j=0; j<test.length && saiDoCiclo==false; j++, indTeste++) {
                if (arr[indTeste] != test[j]) saiDoCiclo=true;
            }
            if (saiDoCiclo == false) reps++;
        }
        return reps;
    }
*/
}
