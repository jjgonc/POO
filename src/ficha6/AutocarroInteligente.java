package ficha6;

import java.util.ArrayList;
import java.util.Objects;

public class AutocarroInteligente extends Veiculo implements BonificaKms{
    private int lotacao;
    private int ocupacao;
    private int pontosAtribuir;
    private int pontosAcumulados;

    public AutocarroInteligente () {
        super();
        this.lotacao = 0;
        this.ocupacao = 0;
        this.pontosAcumulados = 0;
        this.pontosAtribuir = 0;
    }

    public AutocarroInteligente (AutocarroInteligente ai) {
        super (ai);
        this.setLotacao(ai.getLotacao());
        this.setOcupacao(ai.getOcupacao());
        this.pontosAtribuir = ai.getPontosAtribuir();
        this.pontosAcumulados = ai.pontosAcumulados();
    }


    public AutocarroInteligente (String marca, String modelo, String matricula, int ano, double velocidadeMedia, double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo, int ocupacao) {
        super (marca, modelo, matricula, ano, velocidadeMedia, precokm, classificacao, kms, kmsUltimo);
        if (ocupacao > 0 && ocupacao<=100) {
            this.ocupacao = ocupacao;
        }
        else {
            this.ocupacao = 0;
        }
        this.pontosAcumulados=0;
        this.pontosAtribuir = 0;
    }

    public AutocarroInteligente (String marca, String modelo, String matricula, int ano, double velocidadeMedia, double precokm, ArrayList<Integer> classificacao, int kms, int kmsUltimo, int lotacao, int ocupacao) {
        super (marca, modelo, matricula, ano, velocidadeMedia, precokm, classificacao, kms, kmsUltimo);
        this.ocupacao = lotacao;
        this.lotacao = ocupacao;
    }

    public AutocarroInteligente (int ocupacao) {
        super();
        if (ocupacao > 0 && ocupacao<=100) {
            this.ocupacao = ocupacao;
        }
        else {
            this.ocupacao = 0;
        }
        this.pontosAcumulados=0;
        this.pontosAtribuir = 0;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public int getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(int ocupacao) {
        this.ocupacao = ocupacao;
    }

    public AutocarroInteligente clone () {
        return new AutocarroInteligente(this);
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AutocarroInteligente ai = (AutocarroInteligente) o;
        return (super.equals(ai) && this.lotacao == ai.getLotacao() && this.ocupacao == ai.getOcupacao());
    }


    public String toString() {
        final StringBuilder sb = new StringBuilder("AutocarroInteligente{");
        sb.append("lotacao=").append(lotacao);
        sb.append(", ocupacao=").append(ocupacao);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public double custoRealKM() {
        double custoReal = this.getPrecokm()*1.1;       //-> tem que ser assim por causa do abstract
        double ratio = (double) ocupacao / lotacao;
        if (ratio > 0.6) return custoReal * 0.25;
        return custoRealKM() * 0.5;
    }

    @Override
    public void setPontosAtribuir(int pontosAtribuir) {
        this.pontosAtribuir = pontosAtribuir;
    }

    @Override
    public int getPontosAtribuir() {
        return this.pontosAtribuir;
    }

    @Override
    public int pontosAcumulados() {
        return pontosAcumulados;
    }
}
