package view;

import model.Users;
import service.UsuarioService;
import validation.NovoUsuarioValidation;
import validation.UsuarioConectadoSingleton;

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
        if (UsuarioConectadoSingleton.INSTANCE.isConectado()){
            throw new RuntimeException("Você já está registrado!");
        }
        Integer userId = usuarioService.getIdIterator();
        System.out.println("Insira seu nome:");
        String nome = sc.nextLine();
        System.out.println("Insira seu CPF:");
        String cpf = sc.nextLine();
        Users users = new Users(userId, nome, cpf);
        try {
            novoUsuarioValidation.valida(users);
            usuarioService.cadastrarUsuario(users);
        } catch(RuntimeException e){
           e.printStackTrace();
        }
    }
}
