package br.edu.ifpb.domain.venda;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/05/2022, 09:24:15
 */
public class Produto {

    private final String descricao;
    private double valor;

    public Produto(String descricao, double valor) {
        this.descricao = descricao;
        this.valor =valor;
    }
    public double valor(){
        return this.valor;
    }

}
