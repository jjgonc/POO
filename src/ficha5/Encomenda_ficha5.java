package ficha5;

import ficha4.LinhaEncomenda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Encomenda_ficha5 {
    //variáveis de instância
    private String nomeCliente;
    private int nif;
    private String morada;
    private int num_Enc;
    private LocalDate data;
    private List<LinhaEncomenda> linhas;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getNum_Enc() {
        return num_Enc;
    }

    public void setNum_Enc(int num_Enc) {
        this.num_Enc = num_Enc;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<LinhaEncomenda> getLinhas() {
        return linhas;
    }

    public void setLinhas(List<LinhaEncomenda> linhas) {
        this.linhas = linhas.stream().map(LinhaEncomenda::clone).collect(Collectors.toList());
    }

    //construtor por omissao de Encomenda
    public Encomenda_ficha5() {
        this.nomeCliente = "";
        this.nif = -1;
        this.morada = "";   //melhor que null pq null é um apontador vazio
        this.num_Enc = -1;
        this.data = LocalDate.now();
        this.linhas = new ArrayList<>();
    }

    //construtor de copia de Encomenda
    public Encomenda_ficha5(Encomenda_ficha5 e) {    //usar getters e setters
        this.nomeCliente = e.nomeCliente;
        this.nif = e.nif;
        this.morada = e.morada;
        this.num_Enc = e.num_Enc;
        this.data = e.data;
        this.linhas = e.getLinhas();
    }

    //construtor parametrizado de Encomenda
    public Encomenda_ficha5(String nomeCliente, int nif, String morada, int num_Enc, LocalDate data, ArrayList<LinhaEncomenda> linhas) {
        this.nomeCliente = nomeCliente;
        this.nif = nif;
        this.morada = morada;
        this.num_Enc = num_Enc;
        this.data = data;
        this.setLinhas(linhas);
    }

    public String toString() {
        return "Encomenda{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", nif=" + nif +
                ", morada='" + morada + '\'' +
                ", num_Enc=" + num_Enc +
                ", data=" + data +
                ", linhas=" + linhas +
                '}';
    }

    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Encomenda_ficha5 enc = (Encomenda_ficha5) o;
        return (this.nomeCliente.equals(enc.nomeCliente)
                && this.nif == enc.nif
                && this.morada.equals(enc.morada)
                && this.num_Enc == enc.num_Enc
                && this.data.equals(enc.data)
                && this.linhas.equals(enc.linhas));
    }


    public Encomenda_ficha5 clone (){
        return new Encomenda_ficha5(this);
    }


    //ii
    public double calculaValorTotal () {
        return this.linhas.stream().mapToDouble(LinhaEncomenda::calculaValorLinhaEnc).sum();
    }

    //iii
    public double calculaValorDesconto () {
        double valorDesconto = 0.0;
        for (LinhaEncomenda e : this.linhas) {
            valorDesconto += e.calculaValorDesconto();
        }
        return valorDesconto;
    }

    //iv
    public int numeroTotalProdutos () {
        int totalProdutos = 0;
        for (LinhaEncomenda e : this.linhas) {
            totalProdutos += e.getQuantidade();
        }
        return totalProdutos;
    }

    //v
    public boolean existeProdutoEncomenda (String refProduto) {
        for (LinhaEncomenda e : this.linhas) {
            if (e.getReferencia().equals(refProduto)) return true;
        }
        return false;
    }

    //vi
    public void adicionaLinha (LinhaEncomenda linha) {
        this.linhas.add(linha);
    }

    //vii
    public void removeProduto (String codProd) {
        this.linhas.removeIf(code->(codProd.equals(code.getReferencia())));
    }
}
