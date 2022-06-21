package br.edu.ifpb.state;

public class LampadaAnterior {

    private String status = "DESLIGADA";

    public void ligar(){
        System.out.println("A lâmpada está desligada");
        status = "LIGADA";
    }
    public void desligar(){
        System.out.println("A lâmpada está ligada");
        status = "DESLIGADA";
    }
}
class Lampada {
    private Status2 status = new LampadaDesLigada();
    void setStatus(Status2 status) {
        this.status = status;
    }
    void ligar(){
//        if()
        status.ligar(this);
//        for()
    }
    void desligar(){
        status.desligar(this);
    }
}
interface Status2{
    void ligar( Lampada lampada);
    void desligar(Lampada lampada);
}
class LampadaLigada implements  Status2{
    public void ligar(Lampada lampada){
    }
    public void desligar(Lampada lampada){
        System.out.println("A lâmpada está ligada");
        lampada.setStatus(new LampadaDesLigada()); //transição
//        status = "DESLIGADA";
    }
}
class LampadaDesLigada implements  Status2{
    public void ligar(Lampada lampada){
        System.out.println("A lâmpada está desligada");
        lampada.setStatus(new LampadaLigada());
//        status = "LIGADA";
    }
    public void desligar(Lampada lampada){}
}
