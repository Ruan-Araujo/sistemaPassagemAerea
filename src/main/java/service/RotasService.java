package service;

import model.Rotas;
import repository.RotasDAO;

import java.util.List;

public class RotasService{

    private RotasDAO dao;

    public RotasService() {
        this.dao = new RotasDAO();
    }

    public List<Rotas> listarRotas(){
        return dao.listarRotas();
    }

    public Rotas getRotasById(Integer id){
        return dao.listarRotas().stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Rotas getRotasByUser(String name){
        return dao.listarRotas().stream()
                .filter(e -> e.getNome().equals(name))
                .findFirst()
                .orElse(null);
    }
}
