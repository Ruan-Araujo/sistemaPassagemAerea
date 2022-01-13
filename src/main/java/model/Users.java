package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Users {

    private Integer id;
    private String nome;
    private String cpf;
    List<Integer> reservasId = new ArrayList<>();

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

    public List<Integer> getReservasId() {
        return reservasId;
    }

    public void setReservasId(List<Integer> reservasId) {
        this.reservasId = reservasId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(cpf, users.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    @Override
    public String toString() {
        return  "[ " + nome + "," + cpf + "]";
    }
}
