package br.edu.ifpb.domain;

import br.edu.ifpb.domain.venda.ItemDeVenda;
import br.edu.ifpb.domain.venda.Produto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/05/2022, 09:22:50
 */
public abstract class Venda {

    private List<ItemDeVenda> itens = new ArrayList<>();
    private LocalDate criadaEm = LocalDate.now();
    //ctor principal
    public Venda(){}
    public final void confirmar(Entrega entrega){
        double taxas = calcularTaxas(entrega); // cômputo da taxa de entrega
        double subTotal = valorDosItens();
        double valorTotal = subTotal + taxas;
        pagar(valorTotal); // pagar (boleto ou cartão)
    }
    //    delegando à subclasse a responsabilidade de definir o comportamento do pagamento
    protected abstract void pagar(double valor); //hook method

    public double total(Entrega entrega){
        return valorDosItens()  + calcularTaxas(entrega);
    }

    public double calcularTaxas(Entrega entrega){
        return  entrega.taxas(this);
    }

    public double valorDosItens() {
        return itens.stream()
                .mapToDouble(ItemDeVenda::subTotal)
                .sum();
    }
    public void adicionar(int quantidade, Produto produto) {
        ItemDeVenda item = new ItemDeVenda(
                quantidade,produto
        );
        if (!itens.contains(item)) {
            itens.add(item);
        }
    }
    public int itens() {
        return 10;
    }
}
