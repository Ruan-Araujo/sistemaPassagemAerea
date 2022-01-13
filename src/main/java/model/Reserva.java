package model;

import java.util.Objects;

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
}
