package ficha6;

import java.util.ArrayList;

public class VeiculoOcasiao extends Veiculo{
    private static boolean emPromocao;

    public VeiculoOcasiao () {
        super ();
        this.emPromocao = false;
    }

    public VeiculoOcasiao (VeiculoOcasiao v) {
        super (v);
        this.emPromocao = false;
    }

    public VeiculoOcasiao (String marca, String modelo, String matricula, int ano, double velocidadeMedia, double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo) {
        super (marca, modelo, matricula, ano, velocidadeMedia, precokm, classificacao, kms, kmsUltimo);
        this.emPromocao = false;
    }

    public VeiculoOcasiao (String marca, String modelo, String matricula, int ano, double velocidadeMedia, double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo, boolean emPromocao) {
        super (marca, modelo, matricula, ano, velocidadeMedia, precokm, classificacao, kms, kmsUltimo);
        this.emPromocao = emPromocao;
    }

    public VeiculoOcasiao (Veiculo v, boolean emPromocao) {
        super(v);
        this.emPromocao = emPromocao;
    }

    public boolean getemPromocao() {
        return this.emPromocao;
    }

    public void setemPromocao(boolean emPromocao) {
        this.emPromocao = emPromocao;
    }

    public boolean equals (Object o) {
        if (this == o) return true;
        else if (o == null || this.getClass() != o.getClass()) return false;
        VeiculoOcasiao vo = (VeiculoOcasiao) o;
        return (super.equals(o) && this.emPromocao == vo.getemPromocao());
    }

    public Veiculo clone(){
        return new VeiculoOcasiao(this);
    }       //------> deixa de ser VeiculoOcasiao e passa a ser veiculo por causa do abstract (como na classse de veiculoNormal e Premium)

    public String toString() {
        final StringBuilder sb = new StringBuilder("VeiculoOcasiao{");
        sb.append("emPromocao=").append(emPromocao);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public double custoRealKM() {
        double custoReal = 1.1 * this.getPrecokm();
        if (emPromocao) return custoReal * 0.75;
        else return custoReal;
    }
}
