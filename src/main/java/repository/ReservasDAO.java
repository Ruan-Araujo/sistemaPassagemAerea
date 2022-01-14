package repository;

import model.Reserva;
import model.Rotas;
import model.Users;
import service.UsuarioService;
import validation.UsuarioConectadoSingleton;

import java.io.*;
import java.util.*;

public class ReservasDAO{
    private final String RESERVAS_PATH = "src/main/resources/reservas.txt";
    private RotasDAO rotas = new RotasDAO();
    private UsuarioService usuarioService = new UsuarioService();

    protected ReservasDAO() {
        //this.usuarioService = new UsuarioService();
        //this.rotas = new RotasDAO();
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
                Integer idUsuario = Integer.parseInt(dados[4]);
                Users usuario = usuarioService.getUserById(idUsuario);

                Reserva reservas = new Reserva(id, rota, metodoPagamento,
                        totalDePassagens, usuario);
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
        reservas.append(id).append(";");
        reservas.append(rota).append(";");
        reservas.append(metodoPagamento).append(";");
        reservas.append(totalDePassagens).append(";");
        reservas.append(usuarioService.getUserById(reserva.getUsuario().getId()));
        return reservas;
    }
}