package validation;
import Exception.ValidatorException;


public class RealizarReservaValidation implements Validator{
    @Override
    public void valida(Object rota) throws ValidatorException {;
        if (rota == null ){
            throw new ValidatorException("Rota não encontrada, tente novamente!");
        }
    }
}
