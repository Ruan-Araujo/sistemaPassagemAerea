package model;

import java.math.BigDecimal;
import java.util.Date;

public class Rotas {

    private Integer id;
    private String nome;
    private BigDecimal valor;
    private Date dataDeIda;
    private Date dataDeVolta;

    public Rotas(){}

    public Rotas(Integer id, String nome, BigDecimal valor, Date dataDeIda, Date dataDeVolta) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.dataDeIda = dataDeIda;
        this.dataDeVolta = dataDeVolta;
    }
}
