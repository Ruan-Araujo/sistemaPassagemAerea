package view;

import model.Users;
import service.ReservaService;
import service.RotasService;
import service.UsuarioService;
import validation.CancelarReservaValidation;
import validation.ListarReservaValidation;
import validation.UsuarioConectadoSingleton;

import java.util.Scanner;

public class ListarReservaCommand implements Command {
    private Scanner sc = new Scanner(System.in);
    private RotasService rotasService;
    private ReservaService reservaService;
    private ListarReservaValidation listarReservaValidation;
    private UsuarioService usuarioService;

    public ListarReservaCommand() {
        this.listarReservaValidation = new ListarReservaValidation();
        this.rotasService = new RotasService();
        this.usuarioService = new UsuarioService();
        this.reservaService = new ReservaService();
    }

    @Override
    public void execute() {
        if (!UsuarioConectadoSingleton.INSTANCE.isConectado()) {
            throw new RuntimeException("Usuario não esta conectado!");
        }
        Integer userId = UsuarioConectadoSingleton.INSTANCE.getUserId();
        Users users = usuarioService.getUserById(userId);
        try {
            listarReservaValidation.valida(users);
            System.out.println(reservaService.getReservaByUser(users));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
