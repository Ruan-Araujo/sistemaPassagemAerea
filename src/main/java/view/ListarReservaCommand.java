package view;

import exception.ValidatorException;
import model.Users;
import service.ReservaService;
import service.RotasService;
import service.UsuarioService;
import validation.IsConectadoValidation;
import validation.ListarReservaValidation;
import validation.NotConectadoValidation;
import validation.UsuarioConectadoSingleton;

import java.util.Scanner;

public class ListarReservaCommand implements Command {
    private Scanner sc = new Scanner(System.in);
    private RotasService rotasService;
    private ReservaService reservaService;
    private ListarReservaValidation listarReservaValidation;
    private UsuarioService usuarioService;
    private NotConectadoValidation NotConectadoValidation;

    public ListarReservaCommand() {
        this.listarReservaValidation = new ListarReservaValidation();
        this.rotasService = new RotasService();
        this.usuarioService = new UsuarioService();
        this.reservaService = new ReservaService();
        this.NotConectadoValidation = new NotConectadoValidation();
    }

    @Override
    public void execute() {
        try {
            NotConectadoValidation.valida(null);
            Integer userId = UsuarioConectadoSingleton.INSTANCE.getUserId();
            Users users = usuarioService.getUserById(userId);
            listarReservaValidation.valida(users);
            System.out.println(reservaService.getReservaByUser(users));
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());;
        }
    }
}
