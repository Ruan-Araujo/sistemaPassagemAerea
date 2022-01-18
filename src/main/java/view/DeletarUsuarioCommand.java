package view;

import exception.ValidatorException;
import model.Usuario;
import service.UsuarioService;
import validation.*;

import java.util.Scanner;

public class DeletarUsuarioCommand implements Command{

    private UsuarioService usuarioService;
    private CadastrarUsuarioValidation cadastrarUsuarioValidation;
    private DesconectadoValidation desconectadoValidation;
    private Scanner sc = new Scanner(System.in);
    private DeletarUsuarioValidation deletarUsuarioValidation;

    public DeletarUsuarioCommand() {
        this.usuarioService = new UsuarioService();
        this.cadastrarUsuarioValidation = new CadastrarUsuarioValidation();
        this.desconectadoValidation= new DesconectadoValidation();
        this.deletarUsuarioValidation = new DeletarUsuarioValidation();
    }


    @Override
    public void execute() {
        try {

            Integer usuarioId = UsuarioConectadoSingleton.INSTANCE.getUsuarioId();
            Usuario usuarioConectado = usuarioService.getUsuarioById(usuarioId);

            desconectadoValidation.valida(null);
            deletarUsuarioValidation.valida(usuarioConectado);
            usuarioService.deletarUsuario(usuarioConectado);
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
