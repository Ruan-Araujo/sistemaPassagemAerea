package view;

import model.Users;
import validation.UsuarioConectadoSingleton;
import validation.UsuarioValidation;

import java.util.Scanner;

public class ValidarUsuarioCommand implements Command{
    private UsuarioValidation usuarioValidation;
    private Scanner sc = new Scanner(System.in);

    public ValidarUsuarioCommand() {
        this.usuarioValidation = new UsuarioValidation();
    }

    @Override
    public void execute() {
        System.out.println("Insira seu CPF:");
        String cpf = sc.nextLine();
        Users users = new Users(0, null , cpf);
        try {
            usuarioValidation.valida(users);
            UsuarioConectadoSingleton.INSTANCE.conectar();
            System.out.println("Logado com sucesso!");
        } catch(RuntimeException e){
            e.printStackTrace();
        }
    }
}
