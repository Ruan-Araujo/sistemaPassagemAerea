package view;

import exception.ValidatorException;
import model.Users;
import service.UsuarioService;
import validation.IsConectadoValidation;
import validation.UsuarioConectadoSingleton;
import validation.UsuarioValidation;

import java.util.Scanner;

public class ValidarUsuarioCommand implements Command {
    private UsuarioValidation usuarioValidation;
    private UsuarioService usuarioService;
    private IsConectadoValidation isConectadoValidation;
    private Scanner sc = new Scanner(System.in);

    public ValidarUsuarioCommand() {
        this.usuarioValidation = new UsuarioValidation();
        this.usuarioService = new UsuarioService();
        this.isConectadoValidation = new IsConectadoValidation();
    }

    @Override
    public void execute() {
        try {
            isConectadoValidation.valida(null);
            Users users = cadastrarUsuario();
            usuarioValidation.valida(users);
            Integer userId = usuarioService.getUserByCpf(users.getCpf()).getId();
            UsuarioConectadoSingleton.INSTANCE.conectar(userId);
            System.out.println("Logado com sucesso!");
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
        }
    }

    public Users cadastrarUsuario() {
        System.out.println("Insira seu CPF:");
        String cpf = sc.nextLine();
        System.out.println("Insira sua senha:");
        String senha = sc.nextLine();
        Users users = new Users(cpf, senha);
        return users;
    }
}
