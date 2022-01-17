package validation;

import exception.ValidatorException;
import model.Usuario;
import service.ReservaService;

public class CancelarReservaValidation implements Validator {
    private ReservaService reservaService;

    public CancelarReservaValidation() {
        this.reservaService = new ReservaService();
    }

    @Override
    public void valida(Object object) throws ValidatorException {
        Usuario usuario = (Usuario) object;
        if (reservaService.getReservaByUsuario(usuario) == null) {
            throw new ValidatorException("Reserva não encontrada, tente novamente!");
        }
    }
}