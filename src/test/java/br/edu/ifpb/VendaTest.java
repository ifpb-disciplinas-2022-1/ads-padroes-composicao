package br.edu.ifpb;

import br.edu.ifpb.domain.Venda;
import br.edu.ifpb.bridge.VendaAVista;
import br.edu.ifpb.strategy.EntregaPorCorreios;
import br.edu.ifpb.strategy.EntregaPorPAC;
import br.edu.ifpb.strategy.EntregaPorSedex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/05/2022, 09:20:50
 */
public class VendaTest {
    @Test
    public void testEntregaPorSedex(){
        Venda compra = new VendaAVista(new EntregaPorSedex());
        double taxas = compra.calcularTaxas();
        double esperado = 2.0; // 10 itens
        assertEquals(esperado,taxas, 0.0001);
    }
    @Test
    public void testEntregaPorPAC(){
        Venda compra = new VendaAVista(new EntregaPorPAC());
        double taxas = compra.calcularTaxas();
        double esperado = 1.0; // 10 itens
        assertEquals(esperado,taxas, 0.0001);
    }
    @Test
    public void testEntregaPorCorreios(){
        Venda compra = new VendaAVista(new EntregaPorCorreios());
        double taxas = compra.calcularTaxas();
        double esperado = 3.0; // 10 itens
        assertEquals(esperado,taxas, 0.0001);
    }

    @Test
    public void testEntregaPorLambda(){
        Venda compra = new VendaAVista(c -> c.itens() * 0.6);
        double taxas = compra.calcularTaxas();
        double esperado = 6.0; // 10 itens
        assertEquals(esperado,taxas, 0.0001);
    }
}
