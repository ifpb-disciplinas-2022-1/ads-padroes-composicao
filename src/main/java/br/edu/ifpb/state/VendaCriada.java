package br.edu.ifpb.state;

import br.edu.ifpb.domain.Status;
import br.edu.ifpb.domain.Venda;

public class VendaCriada implements Status {

    @Override
    public double total(Venda venda) {
        return venda.valorDosItens() + venda.calcularTaxas();
    }

    @Override
    public void confirmar(Venda venda) {
        double taxas = venda.calcularTaxas(); // hook classes
        double subTotal = venda.valorDosItens();
        double valorTotal = subTotal + taxas;
        venda.pagar(valorTotal); //hook method
        // transição
        venda.setStatus(new VendaFinalizada());
    }
}
