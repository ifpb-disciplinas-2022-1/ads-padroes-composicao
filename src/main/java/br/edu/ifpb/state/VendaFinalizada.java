package br.edu.ifpb.state;

import br.edu.ifpb.domain.Status;
import br.edu.ifpb.domain.Venda;

public class VendaFinalizada implements Status {

    @Override
    public double total(Venda venda) {
        return venda.valorDosItens()  + venda.calcularTaxas();
    }
    @Override
    public void confirmar(Venda venda) {}
}

