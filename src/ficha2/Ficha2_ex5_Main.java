package ficha2;

import java.util.Scanner;

public class Ficha2_ex5_Main {
    public static void main (String [] args) {
        Ficha2_ex5 f = new Ficha2_ex5();
        Scanner sc = new Scanner(System.in);
        Scanner st = new Scanner(System.in);
        System.out.println("Digite o tamanho do array: ");
        int size = sc.nextInt();
        String temp, res;
        String [] arr = new String [size];
        //como fazer o preenchimento da string??? (apagar antes perguntar)
        for (int i = 0; i < size; i++){
            System.out.println("Insert string number " + (i + 1));
            temp = st.nextLine();
            arr[i] = temp;
        }

        //alinea a
        res = f.naoRepetidos(arr);
        System.out.println("Alinea a: " +res);

        //alinea b
        res = f.biggest(arr);
        System.out.println("Alinea b: " +res);

        //alinea c
        res = f.moreThanOnce(arr);
        System.out.println("Alinea c: " +res);

        //alinea d
        System.out.println("Digite a string que pretende ver se ocorre no array:");
        temp = st.nextLine();
        int quantos = f.howMany(arr, temp);
        System.out.println("Alinea d: A string " +temp+ " ocorre " +quantos+ " vezes no array");

    }
}
