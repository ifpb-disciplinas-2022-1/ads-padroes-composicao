package br.edu.ifpb.state;

import br.edu.ifpb.domain.Status;
import br.edu.ifpb.domain.Venda;

public class VendaCancelada implements Status {

    @Override
    public double total(Venda venda) {
        return 0; // Vendas canceladas não possuem total
    }
    @Override
    public void confirmar(Venda venda) {}
}
