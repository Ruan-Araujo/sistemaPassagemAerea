package validation;

import model.Usuario;
import service.UsuarioService;

import exception.ValidatorException;

public class CadastrarUsuarioValidation implements Validator{
    private UsuarioService usuarioService = new UsuarioService();

    @Override
    public void valida(Object usuario){
        Usuario usuarioFornecido = (Usuario) usuario;
        String senha = usuarioFornecido.getSenha();
        Usuario usuarioCadastrado = usuarioService.getUsuarioByCpf(usuarioFornecido.getCpf());

        if (usuario == null || usuarioCadastrado != null | UsuarioConectadoSingleton.INSTANCE.isConectado()){
            throw new ValidatorException("Erro ao cadastrar usuario, tente novamente!");
        }else if(senha.length() < 6 || senha.length() > 12){
            throw new ValidatorException("Senha deve conter no mínimo seis caracteres e no maximo doze caracteres!");
        }
    }

}
