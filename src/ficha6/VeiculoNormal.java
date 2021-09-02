package ficha6;

import java.util.ArrayList;

public class VeiculoNormal extends Veiculo{
    public VeiculoNormal() {
        super();
    }

    public VeiculoNormal(String marca, String modelo, String matricula, int ano, double velociademedia, double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo) {
        super(marca, modelo, matricula,ano,velociademedia,precokm,classificacao,kms, kmsUltimo);
    }

    public VeiculoNormal(Veiculo v){
        super(v);
    }

    public double custoRealKM () {
        return super.getPrecokm()*1.1;
    }

    @Override
    public Veiculo clone() {
        return new VeiculoNormal(this);
    }      // ------> passa a ser Veiculo em vez de veiculo normal por causa do abstract em Veiculo
}
