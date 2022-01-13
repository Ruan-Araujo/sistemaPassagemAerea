package view;

import model.Rotas;
import model.Users;
import service.ReservaService;
import service.RotasService;
import service.UsuarioService;
import validation.CancelarReservaValidation;
import validation.UsuarioConectadoSingleton;

import java.util.Scanner;

public class CancelarReservaCommand implements Command {
    private Scanner sc = new Scanner(System.in);
    private RotasService rotasService;
    private ReservaService reservaService;
    private CancelarReservaValidation cancelarReservaValidation;
    private UsuarioService usuarioService;

    public CancelarReservaCommand() {
        this.cancelarReservaValidation = new CancelarReservaValidation();
        this.rotasService = new RotasService();
        this.usuarioService = new UsuarioService();
    }

    @Override
    public void execute() {
        if (!UsuarioConectadoSingleton.INSTANCE.isConectado()) {
            throw new RuntimeException("Usuario não esta conectado!");
        }
        Integer userId = UsuarioConectadoSingleton.INSTANCE.getUserId();
        Users users = usuarioService.getUserById(userId);
        try {
            cancelarReservaValidation.valida(users);
            reservaService.cancelarReserva(users.getReserva());
            System.out.println("Reserva realizada com sucesso!");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
