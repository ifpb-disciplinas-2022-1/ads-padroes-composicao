package br.edu.ifpb.domain;

public interface Status {
    public double total(Venda venda);

    public void confirmar(Venda venda);
}
