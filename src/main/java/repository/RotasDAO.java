package repository;

import model.Rotas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RotasDAO {
    private final String ROTAS_PATH = "src/main/resources/rotas.txt";

    public List<Rotas> listarRotas() {
        List<Rotas> rotasList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ROTAS_PATH)))) {
            String rota = br.readLine();
            while (rota != null) {
                String[] dados = rota.split(";");
                Integer id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                BigDecimal valor = new BigDecimal(dados[2]);
                LocalDate dataDeIda = LocalDate.parse(dados[3]);
                LocalDate dataDeVolta = LocalDate.parse(dados[4]);
                Rotas rotas = new Rotas(id, nome, valor, dataDeIda, dataDeVolta);
                rotasList.add(rotas);
                rota = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rotasList;
    }
}