package service;

import model.Users;
import repository.UsuarioDAO;

public class CadUsuarioService {

    private UsuarioDAO dao;

    public CadUsuarioService() {
        this.dao = new UsuarioDAO();
    }

    public void cadastrarUsuario(Users user) {
        if (validarUsuario(user)) {
            System.out.println("Usuário já cadastrado");
        } else {
            dao.adicionarUsuarios(user);
        }
    }


    public boolean validarUsuario(Users user) {
        boolean usuarioJaCadastrado = false;

        for (Users usuarios : dao.listarUsuarios()) {
            if (user.equals(usuarios)) {
                usuarioJaCadastrado = true;
                break;
            }
        }

        return usuarioJaCadastrado;
    }
}
