package ficha1;

import java.util.Scanner;

public class TestePrograma {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        ficha1 f = new ficha1();

        //pergunta 1
        System.out.println("Qual é o valor em graus que pretende converter?");
        double g = input.nextDouble();
        double farenheit = f.celsiusToFarenheit(g);
        System.out.println(g + " graus celsius == " +farenheit+ " graus farenheit");


        System.out.println();


        //pergunta 2
        System.out.println("Digite o 1º valor que pretende comprar:");
        int a = input.nextInt();
        System.out.println("Digite o 2º valor que pretende comprar:");
        int b = input.nextInt();
        int res = f.maximoNumeros(a, b);
        System.out.println("O maior dos valores é " +res);


        System.out.println();


        //pergunta 3
        System.out.println("Nome do titular da conta:");
        String nome = input.nextLine();
        System.out.println("Saldo na conta:");
        double saldo = input.nextDouble();

        String resp = f.criaDescricaoConta(nome, saldo);
        System.out.println("Resposta: " +resp);


        System.out.println();


        //pergunta 4
        System.out.println("Valor em euros:");
        double eurValue = input.nextDouble();
        System.out.println("Taxa de conversão:");
        double taxaConv = input.nextDouble();
        double valorConvertido = f.eurosParaLibras(eurValue, taxaConv);
        System.out.println ("A uma taxa de conversao de " +taxaConv+ ", " +eurValue+ " corresponde a " +valorConvertido);


        System.out.println();


        //pergunta 5
        System.out.println("Escreva o 1º numero:");
        int a1 = input.nextInt();
        System.out.println("Escreva o 2º numero:");
        int b1 = input.nextInt();
        if (a1 >= b1) {
            System.out.println(+a1);
            System.out.println(+b1);
        }
        else {
            System.out.println(+b1);
            System.out.println(+a1);
        }
        float result = f.leIntReturnMedia(a1, b1);
        System.out.println("A media dos dois numeros é: " +result);
        System.out.println ("A uma taxa de conversao de " +taxaConv+ ", " +eurValue+ " corresponde a " +valorConvertido);


        System.out.println();


        //pergunta 6
        System.out.println("Escreva o numero que pretende saber o seu fatorial:");
        int x = input.nextInt();
        int fatorial = f.fatorial(x);
        System.out.println("O fatorial de "+x+ " é " +fatorial);


        System.out.println();


        //pergunta 7
        long time = f.tempoGasto();
        System.out.println("O tempo gasto a fazer o fatorial foi de: "+time+ " milissegundos!");
    }
}
