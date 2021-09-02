package ficha1;

public class ficha1 {

    //P1
    public double celsiusToFarenheit (double graus) {
        double f = graus * (9/5) + 32;
        return f;
    }
    //P2
    public int maximoNumeros (int a,int b) {
        if (a >= b) return a;
        else return b;
    }
    //P3
    public String criaDescricaoConta (String nome, double saldo) {
        return ("O " +nome+ " tem " +saldo+ " euros na conta");
    }
    //P4
    public double eurosParaLibras (double valor, double taxaConversao) {
        return (valor * taxaConversao);
    }
    //P5
    public float leIntReturnMedia (int a, int b) {
        int media = (a+b);
        float mean =  media/(float)2;
        return mean;
    }
    //P6
    public int fatorial (int x) {
        int sum = 1;
        int i;
        for (i=x; i>0; i--) {
            sum = sum*i;
        }
        return sum;
    }
    //P7
    public long tempoGasto() {
        long start = System.currentTimeMillis();
        fatorial(50000000);     //fazer de um numero muito elevado pq se for o fatorial de 5000 vai dar zero por ser rapido demais
        long end = System.currentTimeMillis();

        return (end-start);
    }

}
