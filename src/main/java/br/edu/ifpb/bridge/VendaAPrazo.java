package br.edu.ifpb.bridge;

import br.edu.ifpb.domain.Entrega;
import br.edu.ifpb.domain.Venda;

public class VendaAPrazo extends Venda {
    public VendaAPrazo(Entrega entrega) {
        super(entrega);
    }

    @Override
    public void pagar(double valorTotal) {
        System.out.println("Pagamento a prazo no valor de: "+valorTotal);
    }
}
