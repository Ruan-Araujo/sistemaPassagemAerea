package service;

import model.Users;

import java.util.ArrayList;
import java.util.List;

public class CadUsuarioService {

    List<Users> listaUsuarios = new ArrayList<>();


    public void cadastrarUsuario(Users user) {
        listaUsuarios.add(user);
    }

    public void validarUsuario(Users user) {
        listaUsuarios.forEach(users -> {
            if (users.equals(user)) {
                System.out.println("Usuário " + user + "já está cadastrado");
            }
        });
    }
}
