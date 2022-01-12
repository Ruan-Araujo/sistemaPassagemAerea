package model;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private Integer id;
    private String nome;
    private String cpf;
    List<Reserva> listaReservas = new ArrayList<>();

    public Users(){}

    public Users(Integer id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return  "[ " + nome +  cpf + "]";
    }
}
