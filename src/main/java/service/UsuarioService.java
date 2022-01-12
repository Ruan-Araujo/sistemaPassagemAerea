package service;

import model.Users;
import repository.Reader;

import java.util.List;

public class UsuarioService {
        private Reader reader = new Reader();

        public List<Users> listarUsuarios(){
            return reader.listarUsuarios();
        }

        public Users getUserById(Integer id){
            return reader.listarUsuarios().stream()
                    .filter(e -> e.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }

        public Users getUserByName(String nome){
            return reader.listarUsuarios().stream()
                    .filter(e -> e.getNome().equals(nome))
                    .findFirst()
                    .orElse(null);
        }
}
