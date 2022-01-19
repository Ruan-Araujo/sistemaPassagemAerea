package view;

import exception.ValidatorException;
import model.Usuario;
import service.ReservaService;
import service.RotasService;
import service.UsuarioService;
import validation.ListarReservaValidation;
import validation.DesconectadoValidation;
import validation.UsuarioConectadoSingleton;

import java.util.Scanner;

public class ListarReservaCommand implements Command {
    private Scanner sc = new Scanner(System.in);
    private RotasService rotasService;
    private ReservaService reservaService;
    private ListarReservaValidation listarReservaValidation;
    private UsuarioService usuarioService;
    private DesconectadoValidation desconectadoValidation;

    public ListarReservaCommand() {
        this.listarReservaValidation = new ListarReservaValidation();
        this.rotasService = new RotasService();
        this.usuarioService = new UsuarioService();
        this.reservaService = new ReservaService();
        this.desconectadoValidation = new DesconectadoValidation();
    }

    @Override
    public void execute() {
        try {
            desconectadoValidation.valida(null);
            Integer userId = UsuarioConectadoSingleton.INSTANCE.getUsuarioId();
            Usuario usuario = usuarioService.getUsuarioById(userId);
            listarReservaValidation.valida(usuario);
            reservaService.getReservasByUsuario(usuario).forEach(System.out::println);
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());;
        }
    }
}
