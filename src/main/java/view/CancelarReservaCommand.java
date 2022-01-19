package view;

import exception.ValidatorException;
import model.Reserva;
import model.Usuario;
import service.ReservaService;
import service.UsuarioService;
import validation.CancelarReservaValidation;
import validation.DesconectadoValidation;
import validation.UsuarioConectadoSingleton;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CancelarReservaCommand implements Command {
    private Scanner sc = new Scanner(System.in);
    private ReservaService reservaService;
    private CancelarReservaValidation cancelarReservaValidation;
    private UsuarioService usuarioService;
    private DesconectadoValidation desconectadoValidation;

    public CancelarReservaCommand() {
        this.cancelarReservaValidation = new CancelarReservaValidation();
        this.usuarioService = new UsuarioService();
        this.reservaService = new ReservaService();
        this.desconectadoValidation = new DesconectadoValidation();
    }

    @Override
    public void execute() {
        try {
            desconectadoValidation.valida(null);
            Integer usuarioID = UsuarioConectadoSingleton.INSTANCE.getUsuarioId();
            Usuario usuario = usuarioService.getUsuarioById(usuarioID);
            cancelarReservaValidation.valida(usuario);
            List<Reserva> reservas = reservaService.getReservasByUsuario(usuario);
            reservas.forEach(System.out::println);
            System.out.println("Insira o ID da reserva que deseja cancelar:");
            Integer reservaId = sc.nextInt();
            Reserva reserva = reservaService.getReservaById(reservaId, usuario);
            if (reserva == null){
                System.out.println("Reserva não encontrada");
            }else {
                reservaService.cancelarReserva(reserva);
                System.out.println("Reserva cancelada com sucesso!");
            }
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
        }
    }
}
