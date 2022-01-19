package view;

import exception.ValidatorException;
import model.Reserva;
import model.Usuario;
import service.ReservaService;
import service.UsuarioService;
import validation.*;

import java.util.List;

public class DeletarUsuarioCommand implements Command{
    private UsuarioService usuarioService;
    private DesconectadoValidation desconectadoValidation;
    private DeletarUsuarioValidation deletarUsuarioValidation;
    private ReservaService reservaService;

    public DeletarUsuarioCommand() {
        this.usuarioService = new UsuarioService();
        this.desconectadoValidation= new DesconectadoValidation();
        this.deletarUsuarioValidation = new DeletarUsuarioValidation();
        this.reservaService = new ReservaService();
    }

    @Override
    public void execute() {
        try {
            Integer usuarioId = UsuarioConectadoSingleton.INSTANCE.getUsuarioId();
            Usuario usuarioConectado = usuarioService.getUsuarioById(usuarioId);
            desconectadoValidation.valida(null);
            deletarUsuarioValidation.valida(usuarioConectado);
            reservaService.cancelarReservasByUsuario(usuarioConectado);
            usuarioService.deletarUsuario(usuarioConectado);
            UsuarioConectadoSingleton.INSTANCE.desconectar();
            System.out.println("Conta excluida com sucesso!");
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }
    }
//
//    private void cancelarReservas(Usuario usuario){
//        List<Reserva> reservas = reservaService.getReservasByUsuario(usuario);
//        reservas.forEach(e -> reservaService.cancelarReserva(e));
//    }
}
