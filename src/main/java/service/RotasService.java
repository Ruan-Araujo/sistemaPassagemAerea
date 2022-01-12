package service;

import model.Rotas;

import java.util.ArrayList;
import java.util.List;

public class RotasService {

    List<Rotas> listaRotas = new ArrayList<>();

    public void cadastrarRota(Rotas rota) {
        listaRotas.add(rota);
    }

}
