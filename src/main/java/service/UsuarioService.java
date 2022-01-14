package service;

import model.Users;
import repository.UsuarioDAO;

import java.util.List;
import java.util.Objects;

public class UsuarioService {

    private UsuarioDAO dao = new UsuarioDAO();

    public UsuarioService() {
        //this.dao = new UsuarioDAO();
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

    public List<Users> listarUsuarios() {
        return dao.listarUsuarios();
    }

    public Users getUserById(Integer id) {
        return dao.listarUsuarios().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Users getUserByCpf(String cpf) {
        return dao.listarUsuarios().stream()
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
