package model;

public class Reserva {

    private Rotas rota;
    private String metodoPagamento;
    private Integer totalDePassagens;

    public Reserva(){}

    public Reserva(Rotas rota, String metodoPagamento, Integer totalDePassagens) {
        this.rota = rota;
        this.metodoPagamento = metodoPagamento;
        this.totalDePassagens = totalDePassagens;
    }
}
