package ficha1;

public class ficha1_exerciciosI {
    public int diaDaSemana (int dia, int mes, int ano) {
        //determinar o numero total de dias entre 01/01/1900 e a data fornecida
        int res = (ano-1900)*365 + (ano-1900)/4;
        if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0) && (mes == 1 || mes == 2))
            res--;
//alinea c)
        for (int i = mes; i > 0; i--) {
            if (i==2) res += 28;                                    //fevereiro tem 28 dias
            else if (i==4 || i== 6 || i == 9 || i==11) res += 30;   //abril, junho, setembro e novembro tem 30 dias
            else res += 31;                                         //o resto tem 31 dias
        }
        return res;
    }
}
