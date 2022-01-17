package view;

import exception.ValidatorException;
import model.Users;
import service.ReservaService;
import service.UsuarioService;
import validation.CancelarReservaValidation;
import validation.IsConectadoValidation;
import validation.NotConectadoValidation;
import validation.UsuarioConectadoSingleton;

import java.util.Scanner;

public class CancelarReservaCommand implements Command {
    private Scanner sc = new Scanner(System.in);
    private ReservaService reservaService;
    private CancelarReservaValidation cancelarReservaValidation;
    private UsuarioService usuarioService;
    private NotConectadoValidation notConectadoValidation;

    public CancelarReservaCommand() {
        this.cancelarReservaValidation = new CancelarReservaValidation();
        this.usuarioService = new UsuarioService();
        this.reservaService = new ReservaService();
        this.notConectadoValidation = new NotConectadoValidation();
    }

    @Override
    public void execute() {
        try {
            notConectadoValidation.valida(null);
            Integer userId = UsuarioConectadoSingleton.INSTANCE.getUserId();
            Users users = usuarioService.getUserById(userId);
            cancelarReservaValidation.valida(users);
            reservaService.cancelarReserva(reservaService.getReservaByUser(users));
            System.out.println("Reserva cancelada com sucesso!");
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
        }
    }
}
