package validation;

import model.Users;
import service.UsuarioService;

import exception.ValidatorException;
import java.util.List;

public class NovoUsuarioValidation implements Validator{
    private UsuarioService usuarioService = new UsuarioService();

    @Override
    public void valida(Object user){
        Users usuarioFornecido = (Users) user;
        String senha = usuarioFornecido.getSenha();
        Users usuarioCadastrado = usuarioService.getUserByCpf(usuarioFornecido.getCpf());

        if (user == null || usuarioCadastrado != null | UsuarioConectadoSingleton.INSTANCE.isConectado()){
            throw new ValidatorException("Erro ao cadastrar usuario, tente novamente!");
        }else if(senha.length() < 6 || senha.length() > 12){
            throw new ValidatorException("Senha deve conter no mínimo seis caracteres e no maximo doze caracteres!");
        }
    }

}
