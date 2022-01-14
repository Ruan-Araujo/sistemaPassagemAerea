package validation;

import Exception.ValidatorException;
import model.Users;
import service.ReservaService;

public class CancelarReservaValidation implements Validator {

    private ReservaService reservaService;

    public CancelarReservaValidation() {
        this.reservaService = new ReservaService();
    }

    @Override
    public void valida(Object object) throws ValidatorException {
        Users users = (Users) object;
        if (reservaService.getReservaByUser(users) == null) {
            throw new ValidatorException("Reserva não encontrada, tente novamente!");
        }
    }
}