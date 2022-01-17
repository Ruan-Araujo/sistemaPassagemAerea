package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Reserva {
    private Integer id;
    private Rotas rota;
    private String metodoPagamento;
    private Integer totalDePassagens;
    private Users usuario;
    private BigDecimal valorTotal;

    public Reserva(){}

    public Reserva(Integer id, Rotas rota, String metodoPagamento,
                   Integer totalDePassagens, Users usuario) {
        this.id = id;
        this.rota = rota;
        this.metodoPagamento = metodoPagamento;
        this.totalDePassagens = totalDePassagens;
        this.usuario = usuario;
        this.valorTotal = setValorTotal();
    }

    public Reserva(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    private BigDecimal setValorTotal() {
        BigDecimal quantPassagens = new BigDecimal(totalDePassagens);
        BigDecimal valorUnitario = rota.getValor();
        return quantPassagens.multiply(valorUnitario);
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
