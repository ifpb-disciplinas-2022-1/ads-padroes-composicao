package br.edu.ifpb.domain;

public class VendaAPrazo extends Venda {
    @Override
    protected void pagar(double valorTotal) {
        System.out.println("Pagamento a prazo no valor de: "+valorTotal);
    }
}
