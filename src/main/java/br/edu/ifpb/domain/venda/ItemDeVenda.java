package br.edu.ifpb.domain.venda;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/05/2022, 09:23:59
 */
public class ItemDeVenda {

    private final Produto produto;
    private final int quantidade;
    private double desconto;

    public ItemDeVenda(int quantidade, Produto produto) {
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public Produto produto(){
        return this.produto;
    }
    public int quantidade(){
        return this.quantidade;
    }
    
    public double subTotal(){
        return this.produto.valor() * this.quantidade;
    }
    
}
