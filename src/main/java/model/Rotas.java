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

    @Override
    public String toString() {
        return "["+ id + "," + nome + ", " + valor + ", " + dataDeIda + ", "+ dataDeVolta + "]";
    }
}
