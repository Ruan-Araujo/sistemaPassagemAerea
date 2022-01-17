package view;

import model.Usuario;
import service.UsuarioService;
import validation.ConectadoValidation;
import validation.CadastrarUsuarioValidation;
import exception.ValidatorException;

import java.util.Scanner;

public class CadastrarUsuarioCommand implements Command{
    private UsuarioService usuarioService;
    private CadastrarUsuarioValidation cadastrarUsuarioValidation;
    private ConectadoValidation conectadoValidation;
    private Scanner sc = new Scanner(System.in);


    public CadastrarUsuarioCommand() {
        this.usuarioService = new UsuarioService();
        this.cadastrarUsuarioValidation = new CadastrarUsuarioValidation();
        this.conectadoValidation = new ConectadoValidation();
    }

    @Override
    public void execute() {
        try {
            conectadoValidation.valida(null);
            Usuario usuario = cadastrarUsuario();
            cadastrarUsuarioValidation.valida(usuario);
            usuarioService.cadastrarUsuario(usuario);
            System.out.println("Usuario cadastrado com sucesso!");
        }catch(ValidatorException e){
            System.out.println(e.getMessage());
        }
    }

    public Usuario cadastrarUsuario(){
        Integer usuarioId = usuarioService.getIdIterator();
        System.out.println("Insira seu nome:");
        String nome = sc.nextLine();
        System.out.println("Insira seu CPF:");
        String cpf = sc.nextLine();
        System.out.println("Insira sua senha:");
        String senha = sc.nextLine();
        Usuario usuario = new Usuario(usuarioId, nome, cpf, senha);
        return usuario;
    }
}
