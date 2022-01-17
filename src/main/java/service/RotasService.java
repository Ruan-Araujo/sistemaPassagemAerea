package service;

import model.Rotas;
import repository.RotasDAO;

import java.util.List;

public class RotasService{
    private RotasDAO rotasDAO;

    public RotasService() {
        this.rotasDAO = new RotasDAO();
    }

    public List<Rotas> listarRotas(){
        return rotasDAO.listarRotas();
    }

    public Rotas getRotasById(Integer id){
        return rotasDAO.listarRotas().stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Rotas getRotasByUser(String name){
        return rotasDAO.listarRotas().stream()
                .filter(e -> e.getNome().equals(name))
                .findFirst()
                .orElse(null);
    }
}
