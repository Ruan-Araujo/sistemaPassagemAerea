package validation;

import model.Users;
import service.UsuarioService;
import Exception.ValidatorException;

import java.util.List;

public class UsuarioValidation implements Validator{
    private UsuarioService usuarioService = new UsuarioService();

    @Override
    public void valida(Object user) {
        List<Users> users = usuarioService.listarUsuarios();
        Users usuarioFornecido = (Users) user;
        Users usuarioCadastrado = users.stream()
                .filter(e -> e.equals(user))
                .findFirst()
                .orElse(null);
        if (user == null || usuarioCadastrado == null || UsuarioConectadoSingleton.INSTANCE.isConectado()
        || !usuarioFornecido.getSenha().equals(usuarioCadastrado.getSenha())){
            throw new ValidatorException("Erro ao validar usuario, tente novamente!");
        }
    }
}
