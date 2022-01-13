package view;

import model.Users;
import service.UsuarioService;
import validation.NovoUsuarioValidation;

import java.util.Scanner;

public class CadastrarUsuarioCommand implements Command{
    private UsuarioService usuarioService;
    private NovoUsuarioValidation novoUsuarioValidation;
    private Scanner sc = new Scanner(System.in);


    public CadastrarUsuarioCommand() {
        this.usuarioService = new UsuarioService();
        this.novoUsuarioValidation = new NovoUsuarioValidation();
    }

    @Override
    public void execute() {
        System.out.println("Insira seu nome:");
        String nome = sc.nextLine();
        System.out.println("Insira seu CPF:");
        String cpf = sc.nextLine();
        // get ID
        Users users = new Users(5, nome, cpf);
        try {
            novoUsuarioValidation.valida(users);
            usuarioService.cadastrarUsuario(users);
        } catch(RuntimeException e){
           e.printStackTrace();
        }

    }
}
