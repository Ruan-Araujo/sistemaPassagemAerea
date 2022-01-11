package model;

import java.math.BigDecimal;
import java.util.Date;

public class Rotas {

    private String nome;
    private BigDecimal valor;
    private Date dataDeIda;
    private Date dataDeVolta;

    public Rotas(){}

    public Rotas(String nome, BigDecimal valor, Date dataDeIda, Date dataDeVolta) {
        this.nome = nome;
        this.valor = valor;
        this.dataDeIda = dataDeIda;
        this.dataDeVolta = dataDeVolta;
    }




}
