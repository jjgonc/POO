package ficha2;

import java.util.Arrays;

public class Ficha2_ex4_Main {
    public static void main (String[] args){
        int [] a = {99,44,55,66,78,834,34,4,45,3,423,43,5,4631,52,5};
        Ficha2_ex4 f = new Ficha2_ex4(a);
        System.out.println("Array original: " +Arrays.toString(a));
        System.out.println("Array ordenado: " +Arrays.toString(f.ordena()));

        System.out.println("BinarySearch - O elemento pretendido esta no indice " +f.binarySearch (4));     //vai procurar no array desordenado
    }
}
