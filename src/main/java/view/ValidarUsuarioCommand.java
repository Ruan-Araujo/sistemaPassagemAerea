package view;

import exception.ValidatorException;
import model.Usuario;
import service.UsuarioService;
import validation.ConectadoValidation;
import validation.UsuarioConectadoSingleton;
import validation.UsuarioValidation;

import java.util.Scanner;

public class ValidarUsuarioCommand implements Command {
    private UsuarioValidation usuarioValidation;
    private UsuarioService usuarioService;
    private ConectadoValidation conectadoValidation;
    private Scanner sc = new Scanner(System.in);

    public ValidarUsuarioCommand() {
        this.usuarioValidation = new UsuarioValidation();
        this.usuarioService = new UsuarioService();
        this.conectadoValidation = new ConectadoValidation();
    }

    @Override
    public void execute() {
        try {
            conectadoValidation.valida(null);
            Usuario usuario = cadastrarUsuario();
            usuarioValidation.valida(usuario);
            Integer usuarioId = usuarioService.getUsuarioByCpf(usuario.getCpf()).getId();
            UsuarioConectadoSingleton.INSTANCE.conectar(usuarioId);
            System.out.println("Logado com sucesso!");
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
        }
    }

    public Usuario cadastrarUsuario() {
        System.out.println("Insira seu CPF:");
        String cpf = sc.nextLine();
        System.out.println("Insira sua senha:");
        String senha = sc.nextLine();
        Usuario usuario = new Usuario(cpf, senha);
        return usuario;
    }
}
