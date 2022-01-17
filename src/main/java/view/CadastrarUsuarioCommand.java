package view;

import model.Users;
import service.UsuarioService;
import validation.IsConectadoValidation;
import validation.NovoUsuarioValidation;
import validation.UsuarioConectadoSingleton;
import exception.ValidatorException;

import java.util.Scanner;

public class CadastrarUsuarioCommand implements Command{
    private UsuarioService usuarioService;
    private NovoUsuarioValidation novoUsuarioValidation;
    private IsConectadoValidation isConectadoValidation;
    private Scanner sc = new Scanner(System.in);


    public CadastrarUsuarioCommand() {
        this.usuarioService = new UsuarioService();
        this.novoUsuarioValidation = new NovoUsuarioValidation();
        this.isConectadoValidation = new IsConectadoValidation();
    }

    @Override
    public void execute() {
        try {
            isConectadoValidation.valida(null);
            Users users = cadastrarUsuario();
            novoUsuarioValidation.valida(users);
            usuarioService.cadastrarUsuario(users);
            System.out.println("Usuario cadastrado com sucesso!");
        }catch(ValidatorException e){
            System.out.println(e.getMessage());
        }
    }

    public Users cadastrarUsuario(){
        Integer userId = usuarioService.getIdIterator();
        System.out.println("Insira seu nome:");
        String nome = sc.nextLine();
        System.out.println("Insira seu CPF:");
        String cpf = sc.nextLine();
        System.out.println("Insira sua senha:");
        String senha = sc.nextLine();
        Users users = new Users(userId, nome, cpf, senha);
        return users;
    }
}
