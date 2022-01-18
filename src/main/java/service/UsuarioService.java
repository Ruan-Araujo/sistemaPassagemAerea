package service;

import model.Usuario;
import repository.UsuarioDAO;

import java.util.List;

public class UsuarioService {
    private UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarioDAO.adicionarUsuarios(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listarUsuarios();
    }

    public Usuario getUsuarioById(Integer id) {
        return usuarioDAO.listarUsuarios().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Usuario getUsuarioByCpf(String cpf){
        return usuarioDAO.listarUsuarios().stream()
                .filter(e -> e.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public Integer getIdIterator() {
        List<Usuario> listaUsuarios = listarUsuarios();
        int quantidadeUsuarios = listaUsuarios.size();
        if (quantidadeUsuarios == 0) {
            return 1;
        } else {
            Integer id = listaUsuarios.get(quantidadeUsuarios - 1).getId() + 1;
            return id;
        }
    }

    public void deletarUsuario(Usuario usuario) {
        usuarioDAO.deletarUsuario(usuario);
    }
}
