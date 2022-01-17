package validation;

import model.Users;
import service.UsuarioService;
import exception.ValidatorException;

import java.util.List;

public class UsuarioValidation implements Validator{
    private UsuarioService usuarioService = new UsuarioService();

    @Override
    public void valida(Object user) {
        Users usuarioFornecido = (Users) user;
        Users usuarioCadastrado = usuarioService.getUserByCpf(usuarioFornecido.getCpf());
        if (usuarioFornecido == null || usuarioCadastrado == null || UsuarioConectadoSingleton.INSTANCE.isConectado()
        || !usuarioFornecido.getSenha().equals(usuarioCadastrado.getSenha())){
            throw new ValidatorException("Erro ao validar usuario, tente novamente!");
        }
    }
}
