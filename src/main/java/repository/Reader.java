package repository;

import model.Reserva;
import model.Rotas;
import model.Users;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Reader {
    private final String USERS_PATH = "src/main/resources/users.txt";
    private final String ROTAS_PATH = "src/main/resources/rotas.txt";
    private final String RESERVAS_PATH = "src/main/resources/reservas.txt";

    //users
    public List<Users> listarUsuarios() {
        List<Users> usersList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(USERS_PATH)))) {
            String user = br.readLine();
            while (user != null) {
                List<String> dados = Arrays.asList(user.split(";"));
                int id = Integer.parseInt(dados.get(0));
                String nome = dados.get(1);
                String cpf = dados.get(2);
                Users users = new Users(id, nome, cpf);

                List<Integer> idReservas = dados.stream()
                                             .skip(3)
                                             .map(Integer::parseInt)
                                             .collect(Collectors.toList());
                users.setReservasId(idReservas);
                usersList.add(users);
                user = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public Users adicionarUsuarios(Users users) {
        StringBuilder user = userToString(users);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(USERS_PATH)))){
            bw.append(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    private StringBuilder userToString(Users users){
        StringBuilder user = new StringBuilder();
        int id = users.getId();
        String nome = users.getNome();
        String cpf = users.getCpf();
        user.append(id);
        user.append(nome);
        user.append(cpf);
        users.getReservasId().forEach(e -> user.append(e.toString()));
        return user;
    }

    // rotas
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

    // reservas
    public List<Reserva> listarReservas() {
        List<Reserva> reservasList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(RESERVAS_PATH)))) {
            String reserva = br.readLine();
            while (reserva != null) {
                String[] dados = reserva.split(";");
                Integer id = Integer.parseInt(dados[0]);
                Integer idRota = Integer.parseInt(dados[1]);
                Rotas rota = listarRotas().stream()
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