package br.edu.ifpb.domain;

public class VendaAVista extends Venda {
        @Override
    protected void pagar(double valorTotal) {
        System.out.println("Pagamento a vista no valor de: "+valorTotal);
    }

}
