package service;

import model.Users;
import repository.UsuarioDAO;

import java.util.List;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrarUsuario(Users user) {
        if (validarUsuario(user)) {
            System.out.println("Usuário já cadastrado");
        } else {
            usuarioDAO.adicionarUsuarios(user);
        }
    }

    public boolean validarUsuario(Users user) {
        boolean usuarioJaCadastrado = false;

        for (Users usuarios : usuarioDAO.listarUsuarios()) {
            if (user.equals(usuarios)) {
                usuarioJaCadastrado = true;
                break;
            }
        }
        return usuarioJaCadastrado;
    }

    public List<Users> listarUsuarios() {
        return usuarioDAO.listarUsuarios();
    }

    public Users getUserById(Integer id) {
        return usuarioDAO.listarUsuarios().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Users getUserByCpf(String cpf) throws RuntimeException{
        return usuarioDAO.listarUsuarios().stream()
                .filter(e -> e.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public Integer getIdIterator(){
        List<Users> listaUsuarios = listarUsuarios();
        int sizeUsuarios = listaUsuarios.size();
        if (sizeUsuarios == 0){
            return 1;
        }else {
            Integer id = listaUsuarios.get(sizeUsuarios - 1).getId() + 1;
            return  id;
        }
    }
}
