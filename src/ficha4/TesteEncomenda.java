package ficha4;

import java.time.LocalDate;
import java.util.ArrayList;

public class TesteEncomenda {
    public static void main (String [] args) {
        Encomenda enc = new Encomenda("José", 255001337, "Rua da Casa", 123, LocalDate.now(), new ArrayList<LinhaEncomenda>());
        System.out.println("Lista de Encomendas: " +enc.toString());

        //adicionar uma compra
        LinhaEncomenda novaLinha = new LinhaEncomenda ("00001", "MacBook Pro", 2999.99, 1, 0.23, 0.2);
        enc.adicionaLinha(novaLinha);
        System.out.println("Nova linha de encomenda adicionada: " +novaLinha.toString());

        //adicionar uma segunda compra
        LinhaEncomenda novaLinha2 = new LinhaEncomenda ("00002", "iPhone 12 Pro", 1099.99, 1, 0.23, 0.1);
        enc.adicionaLinha(novaLinha2);
        System.out.println("Nova linha de encomenda adicionada: " +novaLinha2.toString());

        double valorTotal = 0.0;
        valorTotal = enc.calculaValorTotal();
        System.out.println("O valor total das encomendas é de " +valorTotal+ ".");

        double valorDescontos = 0.0;
        valorDescontos = enc.calculaValorDesconto();
        System.out.println("O valor dos descontos é de " +valorDescontos+ ".");

        int nTotalProd = 0;
        nTotalProd = enc.numeroTotalProdutos();
        System.out.println("A encomenda tem, no total, " +nTotalProd+ " produtos.");

        System.out.printf("A encomenda com a referência '1234' %s\n", enc.existeProdutoEncomenda("1234") ? "EXISTE" : "NÃO EXISTE");

        System.out.println("A remover o produto com a referência '00001'...");
        enc.removeProduto("00001"); //remover o MacBook Pro
        System.out.println("Linha de encomendas atualizada: " +novaLinha2);

    }
}
