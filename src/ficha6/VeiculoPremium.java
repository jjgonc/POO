package ficha6;

import java.util.ArrayList;

public class VeiculoPremium extends Veiculo implements BonificaKms {
    private double taxaLuxo;
    private int pontosAtribuir;
    private int pontosAcumulados;

    public VeiculoPremium () {
        super();
        this.taxaLuxo = 0;
        this.pontosAcumulados = 0;
        this.pontosAtribuir = 0;
    }

    public VeiculoPremium (String marca, String modelo, String matricula, int ano, double velocidadeMedia, double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo) {
        super (marca, modelo, matricula, ano, velocidadeMedia, precokm, classificacao, kms, kmsUltimo);
        this.taxaLuxo = 0;
        pontosAcumulados = 0;
        pontosAtribuir = 0;
    }

    public VeiculoPremium (String marca, String modelo, String matricula, int ano, double velocidadeMedia, double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo, double taxaLuxo) {
        super (marca, modelo, matricula, ano, velocidadeMedia, precokm, classificacao, kms, kmsUltimo);
        this.taxaLuxo = taxaLuxo;
        pontosAcumulados = 0;
        pontosAtribuir = 0;
    }

    public VeiculoPremium (VeiculoPremium v) {
        super(v);
        this.taxaLuxo = v.getTaxaLuxo();
        pontosAtribuir = v.getPontosAtribuir();
        pontosAcumulados = v.pontosAcumulados;
    }

    public double getTaxaLuxo () {
        return this.taxaLuxo;
    }

    public void setTaxaLuxo (double taxaLuxo) {
        this.taxaLuxo = taxaLuxo;
    }

    public Veiculo clone () {
        return new VeiculoPremium(this);
    }  //----> deixa de ser do tipo veiculoPremium por causa do abstract em veiculo

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VeiculoPremium that = (VeiculoPremium) o;
        return this.equals(that);
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("VeiculoPremium{");
        sb.append("taxaLuxo=").append(taxaLuxo);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public double custoRealKM() {
        double custoReal = this.getPrecokm()*1.1;
        return custoReal * this.taxaLuxo;
    }

    @Override
    public void setPontosAtribuir(int pontosAtribuir) {

    }

    @Override
    public int getPontosAtribuir() {
        return pontosAtribuir;
    }

    @Override
    public int pontosAcumulados() {
        return pontosAcumulados;
    }

    public void addViagem (int nKms) {
        super.addViagem(nKms);
        this.pontosAcumulados += nKms*pontosAtribuir;
    }

    @Override
    public String toCSV() {
        return super.toCSV() + taxaLuxo + ":" + pontosAtribuir + ":" + pontosAcumulados;
    }
    
}
