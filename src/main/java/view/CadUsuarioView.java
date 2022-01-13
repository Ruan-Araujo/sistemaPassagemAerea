package view;

import model.Users;
import service.CadUsuarioService;
import service.UsuarioService;

import java.util.Scanner;

public class CadUsuarioView {

    public static void main(String[] args) {

        UsuarioService usuarioService = new UsuarioService();
        System.out.println(usuarioService.listarUsuarios());

        CadUsuarioService cadastrador = new CadUsuarioService();
        Scanner input = new Scanner(System.in);

        System.out.println("Bem vindo a Five Passagens Áreas");
        System.out.println("Realize seu cadastro!");
        System.out.println("Digite seu nome: ");
        String nome = input.nextLine();
        System.out.println("Digite seu cpf: ");
        String cpf = input.nextLine();

        Users usuario = new Users(1, nome, cpf);

        cadastrador.cadastrarUsuario(usuario);

        System.out.println(usuarioService.listarUsuarios());
    }

}
