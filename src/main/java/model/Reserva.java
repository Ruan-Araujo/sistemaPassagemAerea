package model;

public class Reserva {

    private Integer id;
    private Rotas rota;
    private String metodoPagamento;
    private Integer totalDePassagens;

    public Reserva(){}

    public Reserva(Integer id, Rotas rota, String metodoPagamento, Integer totalDePassagens) {
        this.id = id;
        this.rota = rota;
        this.metodoPagamento = metodoPagamento;
        this.totalDePassagens = totalDePassagens;
    }
}
