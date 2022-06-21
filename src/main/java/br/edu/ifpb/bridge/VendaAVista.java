package br.edu.ifpb.bridge;

import br.edu.ifpb.domain.Entrega;
import br.edu.ifpb.domain.Venda;

public class VendaAVista extends Venda {
    public VendaAVista(Entrega entrega) {
        super(entrega);
    }

    @Override
    public void pagar(double valorTotal) {
        System.out.println("Pagamento a vista no valor de: "+valorTotal);
    }

}
