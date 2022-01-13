package service;

import model.Users;
import repository.UsuarioDAO;

import java.util.List;

public class UsuarioService {

    private UsuarioDAO dao;

    public UsuarioService(UsuarioDAO dao) {
        this.dao = new UsuarioDAO();
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
