package service;

import model.Reserva;
import model.Rotas;
import model.Users;
import repository.Reader;

import java.util.ArrayList;
import java.util.List;

public class RotasService {

    private Reader reader = new Reader();

    public List<Rotas> listarRotas(){
        return reader.listarRotas();
    }

    public Rotas getRotasById(Integer id){
        return reader.listarRotas().stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Rotas getRotasByUser(String name){
        return reader.listarRotas().stream()
                .filter(e -> e.getNome().equals(name))
                .findFirst()
                .orElse(null);
    }
}
