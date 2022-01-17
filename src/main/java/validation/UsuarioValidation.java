package validation;

import model.Usuario;
import service.UsuarioService;
import exception.ValidatorException;

public class UsuarioValidation implements Validator{
    private UsuarioService usuarioService;

    public UsuarioValidation() {
        this.usuarioService = new UsuarioService();
    }

    @Override
    public void valida(Object usuario) {
        Usuario usuarioFornecido = (Usuario) usuario;
        Usuario usuarioCadastrado = usuarioService.getUsuarioByCpf(usuarioFornecido.getCpf());
        if (usuarioFornecido == null || usuarioCadastrado == null || UsuarioConectadoSingleton.INSTANCE.isConectado()
        || !usuarioFornecido.getSenha().equals(usuarioCadastrado.getSenha())){
            throw new ValidatorException("Erro ao validar usuario, tente novamente!");
        }
    }
}
