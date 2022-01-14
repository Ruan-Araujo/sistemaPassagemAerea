package view;

import model.Users;
import service.UsuarioService;
import validation.UsuarioConectadoSingleton;
import validation.UsuarioValidation;

import java.util.Scanner;

public class ValidarUsuarioCommand implements Command{
    private UsuarioValidation usuarioValidation;
    private UsuarioService usuarioService;
    private Scanner sc = new Scanner(System.in);

    public ValidarUsuarioCommand() {
        this.usuarioValidation = new UsuarioValidation();
        this.usuarioService = new UsuarioService();
    }

    @Override
    public void execute() {
        System.out.println("Insira seu CPF:");
        String cpf = sc.nextLine();
        Users users = usuarioService.getUserByCpf(cpf);
        try {
            usuarioValidation.valida(users);
            UsuarioConectadoSingleton.INSTANCE.conectar(users.getId());
            System.out.println("Logado com sucesso!");
        } catch(RuntimeException e){
            e.printStackTrace();
        }
    }
}
