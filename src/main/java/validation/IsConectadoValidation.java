package validation;

import exception.ValidatorException;

public class IsConectadoValidation implements Validator{


    @Override
    public void valida(Object objeto) throws ValidatorException {
        if (UsuarioConectadoSingleton.INSTANCE.isConectado())
            throw new ValidatorException("Usuario já está conectado!");
    }
}
