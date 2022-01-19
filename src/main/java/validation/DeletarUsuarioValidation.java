package validation;

import exception.ValidatorException;
import model.Usuario;
import service.UsuarioService;

import java.util.Scanner;

public class DeletarUsuarioValidation implements Validator{

    private UsuarioService usuarioService = new UsuarioService();
    Scanner input = new Scanner(System.in);

    @Override
    public void valida(Object objeto) throws ValidatorException {
        Usuario usuarioFornecido = (Usuario) objeto;
        System.out.println("Ao deletar a conta todas suas reservas seram canceladas, deseja continuar?");
        System.out.println("Digite sua senha para apagar conta: ");
        String senha = input.next();

        if (!usuarioFornecido.getSenha().equals(senha)) {
            throw new ValidatorException("Senha incorreta, tente novamente");
        }
    }
}
