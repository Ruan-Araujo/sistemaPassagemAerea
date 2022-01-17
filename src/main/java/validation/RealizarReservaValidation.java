package validation;

import exception.ValidatorException;

public class RealizarReservaValidation implements Validator{
    @Override
    public void valida(Object reserva) throws ValidatorException {;
        if (reserva == null ){
            throw new ValidatorException("Compra cancelada com sucesso!");
        }
    }
}
