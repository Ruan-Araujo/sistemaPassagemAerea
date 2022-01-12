package repository;

import model.Users;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Reader {
    private final String PATH = "src/main/resources/users.txt";

    public List<Users> listarUsuarios() {
        List<Users> usersList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(PATH)))) {
            String user = br.readLine();
            while (user != null) {
                List<String> dados = Arrays.asList(user.split(";"));
                int id = Integer.parseInt(dados.get(0));
                String nome = dados.get(1);
                String cpf = dados.get(2);
                Users users = new Users(id, nome, cpf);

                List<Integer> idReservas = dados.stream()
                                             .skip(3)
                                             .map(e -> Integer.parseInt(e))
                                             .collect(Collectors.toList());
                usersList.add(users);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public Users adicionarUsuarios(Users users) {
        StringBuilder user = userToString(users);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(PATH)))){
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
        return user;
    }
}
