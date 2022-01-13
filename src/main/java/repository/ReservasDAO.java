package repository;

import model.Reserva;
import model.Rotas;

import java.io.*;
import java.util.*;

public class ReservasDAO{
    private final String RESERVAS_PATH = "src/main/resources/reservas.txt";
    private RotasDAO rotas = new RotasDAO();

    protected ReservasDAO() {
    }

    public List<Reserva> listarReservas() {
        List<Reserva> reservasList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(RESERVAS_PATH)))) {
            String reserva = br.readLine();
            while (reserva != null) {
                String[] dados = reserva.split(";");
                Integer id = Integer.parseInt(dados[0]);
                Integer idRota = Integer.parseInt(dados[1]);
                Rotas rota = rotas.listarRotas().stream()
                        .filter(e -> e.getId().equals(idRota))
                        .findFirst()
                        .orElse(null);
                String metodoPagamento = dados[2];
                Integer totalDePassagens = Integer.parseInt(dados[3]);
                Reserva reservas = new Reserva(id, rota, metodoPagamento, totalDePassagens);
                reservasList.add(reservas);
                reserva = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reservasList;
    }

    public Reserva adicionarReserva(Reserva reserva) {
        StringBuilder reservas = reservasToString(reserva);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(RESERVAS_PATH)))){
            bw.append(reservas);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reserva;
    }

    private StringBuilder reservasToString(Reserva reserva){
        StringBuilder reservas = new StringBuilder();
        Integer id = reserva.getId();
        Rotas rota = reserva.getRota();
        String metodoPagamento = reserva.getMetodoPagamento();
        Integer totalDePassagens = reserva.getTotalDePassagens();
        reservas.append(id);
        reservas.append(rota);
        reservas.append(metodoPagamento);
        reservas.append(totalDePassagens);
        return reservas;
    }
}