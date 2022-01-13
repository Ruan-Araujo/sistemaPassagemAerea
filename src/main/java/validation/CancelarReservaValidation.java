package validation;

import Exception.ValidatorException;
import model.Users;

public class CancelarReservaValidation implements Validator {
    @Override
    public void valida(Object object) throws ValidatorException {
        Users users = (Users) object;
        if (users.getReservas() == null) {
            throw new ValidatorException("Reserva não encontrada, tente novamente!");
        }
    }
}