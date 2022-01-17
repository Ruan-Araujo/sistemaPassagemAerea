package validation;
import exception.ValidatorException;

public class RotaValidation implements Validator{
    @Override
    public void valida(Object rota) throws ValidatorException {;
        if (rota == null ){
            throw new ValidatorException("Rota não encontrada, tente novamente!");
        }
    }
}