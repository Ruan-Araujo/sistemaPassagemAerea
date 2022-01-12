package service;

import model.Users;
import repository.Reader;

public class CadUsuarioService {

    private Reader reader;

    public void cadastrarUsuario(Users user) {
        if (validarUsuario(user)) {
            System.out.println("Usuário já cadastrado");
        } else {
            reader.adicionarUsuarios(user);
        }
    }


    public boolean validarUsuario(Users user) {
        boolean usuarioJaCadastrado = false;

        for (Users usuarios : reader.listarUsuarios()) {
            if (user.equals(usuarios)) {
                usuarioJaCadastrado = true;
                break;
            }
        }

        return usuarioJaCadastrado;
    }
}
