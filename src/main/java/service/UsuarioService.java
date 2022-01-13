package service;

import model.Users;
import repository.UsuarioDAO;

import java.util.List;

public class UsuarioService {

    private UsuarioDAO dao;

    public UsuarioService() {
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

    public List<Users> listarUsuarios(){
            return dao.listarUsuarios();
        }

        public Users getUserById(Integer id){
            return dao.listarUsuarios().stream()
                    .filter(e -> e.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }

        public Users getUserByName(String nome){
            return dao.listarUsuarios().stream()
                    .filter(e -> e.getNome().equals(nome))
                    .findFirst()
                    .orElse(null);
        }
}
