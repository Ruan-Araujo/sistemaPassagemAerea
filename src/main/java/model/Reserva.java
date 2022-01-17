package model;

import java.util.Objects;

public class Reserva {
    private Integer id;
    private Rotas rota;
    private String metodoPagamento;
    private Integer totalDePassagens;
    private Users usuario;

    public Reserva(){}

    public Reserva(Integer id, Rotas rota, String metodoPagamento,
                   Integer totalDePassagens, Users usuario) {
        this.id = id;
        this.rota = rota;
        this.metodoPagamento = metodoPagamento;
        this.totalDePassagens = totalDePassagens;
        this.usuario = usuario;
    }

    public Reserva(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Rotas getRota() {
        return rota;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public Integer getTotalDePassagens() {
        return totalDePassagens;
    }

    public Users getUsuario() {
        return usuario;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "\bReserva" +
                "\nId = " + id +
                "\nRota = " + rota +
                "\nMetodo de Pagamento = " + metodoPagamento +
                "\nTotal de Passagens = " + totalDePassagens;
    }
}
