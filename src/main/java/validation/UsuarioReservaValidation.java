package validation;

import exception.ValidatorException;
import model.Reserva;
import model.Usuario;
import service.ReservaService;

public class UsuarioReservaValidation implements Validator{
    private ReservaService reservaService;

    public UsuarioReservaValidation() {
        this.reservaService = new ReservaService();
    }

    @Override
    public void valida(Object objeto) throws ValidatorException {
        Usuario usuario = (Usuario) objeto;
        Reserva reserva = reservaService.getReservaByUsuario(usuario);
        if (reserva != null){
            throw new ValidatorException("Usuario já possui uma reserva!");
        }
    }
}
