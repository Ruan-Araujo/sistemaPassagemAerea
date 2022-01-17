package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Users {

    private Integer id;
    private String nome;
    private String cpf;
    private String senha;

    public Users(){}

    public Users(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public Users(Integer id, String nome, String cpf, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
