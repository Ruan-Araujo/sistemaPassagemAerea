package repository;

import model.Reserva;
import model.Rotas;
import model.Users;
import service.UsuarioService;

import java.io.*;
import java.util.*;

public class ReservasDAO{
    private final String RESERVAS_PATH = "src/main/resources/reservas.txt";
    private RotasDAO rotas;
    private UsuarioService usuarioService;
    private List<Reserva> reservasList;

    public ReservasDAO() {
        this.rotas = new RotasDAO();
        this.usuarioService = new UsuarioService();
    }

    public List<Reserva> listarReservas() {
        reservasList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(RESERVAS_PATH)))) {
            String linha = br.readLine();
            while (linha != null) {
                String[] dados = linha.split(";");
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

                Reserva reserva = new Reserva(id, rota, metodoPagamento,
                        totalDePassagens, usuario);
                reservasList.add(reserva);
                linha = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reservasList;
    }

    public Reserva adicionarReserva(Reserva reserva) {
        StringBuilder reservas = reservasToString(reserva);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(RESERVAS_PATH, true)))){
            bw.append(reservas);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reserva;
    }

    private StringBuilder reservasToString(Reserva reserva){
        StringBuilder reservas = new StringBuilder();
        Integer id = reserva.getId();
        Rotas rota = reserva.getRota();
        Integer rotaId = rota.getId();
        Integer userId = reserva.getUsuario().getId();
        String metodoPagamento = reserva.getMetodoPagamento();
        Integer totalDePassagens = reserva.getTotalDePassagens();
        reservas.append(id).append(";");
        reservas.append(rotaId).append(";");
        reservas.append(metodoPagamento).append(";");
        reservas.append(totalDePassagens).append(";");
        reservas.append(userId);
        return reservas;
    }

    public void deletarReserva(Reserva reserva) {
        listarReservas();
        limparArquivoTexto();
        if (reservasList.size() != 1) {
            reservasList.removeIf(e -> e.equals(reserva));
            reservasList.forEach(this::adicionarReserva);
        }
    }

    private void limparArquivoTexto(){
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(RESERVAS_PATH)))){
            bw.append("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}