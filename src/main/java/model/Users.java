package model;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private String nome;
    private String cpf;
    List<Reserva> listaReservas = new ArrayList<>();

    public Users(){}

    public Users(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }


    @Override
    public String toString() {
        return  "[ " + nome +  cpf + "]";
    }
}
