package validation;

import Exception.ValidatorException;
import model.Users;
import service.ReservaService;

public class ListarReservaValidation implements Validator {

    private ReservaService reservaService;

    public ListarReservaValidation() {
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