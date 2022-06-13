package br.edu.ifpb.main;

import br.edu.ifpb.domain.Entrega;
import br.edu.ifpb.domain.Venda;
import br.edu.ifpb.domain.VendaAVista;
import br.edu.ifpb.domain.venda.Produto;
import br.edu.ifpb.strategy.EntregaPorCorreios;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/05/2022, 09:22:50
 */
public class Contexto {

    public static void main(String[] args) {
        Produto arroz = new Produto(
            "arroz",4.50
        );
        Produto leite = new Produto(
            "leite",5.00
        );
        Produto cafe = new Produto(
            "cafe",3.50
        );
        Entrega entrega = new EntregaPorCorreios();
        Venda venda = new VendaAVista();
        venda.adicionar(10, arroz); //45
        venda.adicionar(5, leite); //30
        venda.adicionar(10, cafe); //35
        venda.confirmar(entrega); //110
    }
}
