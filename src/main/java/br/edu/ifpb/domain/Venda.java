package br.edu.ifpb.domain;

import br.edu.ifpb.domain.venda.ItemDeVenda;
import br.edu.ifpb.domain.venda.Produto;
import br.edu.ifpb.state.VendaCancelada;
import br.edu.ifpb.state.VendaCriada;

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
    private Entrega entrega; //bridge
    private Status status = new VendaCriada();// = "CRIADA";//, "CANCELADA", "FINALIZADA"
    //    public Venda(){}
    //ctor principal
    public Venda(Entrega entrega) {
        this.entrega = entrega;
    }

    // Se não estiver CANCELADA
    public final void confirmar(){ //similar a finalizar a compra
//        if(!"CANCELADA".equals(status.trim())){
//            double taxas = calcularTaxas(); // hook classes
//            double subTotal = valorDosItens();
//            double valorTotal = subTotal + taxas;
//            pagar(valorTotal); //hook method
//        }
        status.confirmar(this);
    }
    //    delegando à subclasse a responsabilidade de definir o comportamento do pagamento
    public abstract void pagar(double valor); // pagar (boleto ou cartão)

    // CRIADA ou FINALIZADA
    public double total(){
//        if("CRIADA".equals(status.trim()) || "FINALIZADA".equals(status.trim()))
//            return valorDosItens()  + calcularTaxas();
//        return 0; // Vendas canceladas não possuem total
        return status.total(this);
    }
    public double calcularTaxas(){
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
    public void setStatus(Status status){
        this.status = status;
    }
    // novo método para cancelar
    void cancelar(){
        setStatus(new VendaCancelada());
    }
}



