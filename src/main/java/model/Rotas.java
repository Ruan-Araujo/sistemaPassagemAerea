package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Rotas {

    private Integer id;
    private String nome;
    private BigDecimal valor;
    private LocalDate dataDeIda;
    private LocalDate dataDeVolta;

    public Rotas(){}

    public Rotas(Integer id, String nome, BigDecimal valor, LocalDate dataDeIda, LocalDate dataDeVolta) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.dataDeIda = dataDeIda;
        this.dataDeVolta = dataDeVolta;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Id = "+ id + " | " + nome + " | Valor = " + valor + " | Data de ida =  " + dataDeIda + " | Data de volta = "+ dataDeVolta;
    }
}
