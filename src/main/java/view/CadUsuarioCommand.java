package view;

import model.Users;
import service.CadUsuarioService;
import validation.NovoUsuarioValidation;

import java.util.Scanner;

public class CadUsuarioCommand implements Command{
    private CadUsuarioService cadUsuarioService;
    private NovoUsuarioValidation novoUsuarioValidation;
    private Scanner sc = new Scanner(System.in);


    public CadUsuarioCommand() {
        this.cadUsuarioService = new CadUsuarioService();
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
            cadUsuarioService.cadastrarUsuario(users);
        } catch(RuntimeException e){
           e.printStackTrace();
        }

    }
}
