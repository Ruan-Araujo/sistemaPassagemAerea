package validation;

import exception.ValidatorException;

public class NotConectadoValidation implements Validator{


    @Override
    public void valida(Object objeto) throws ValidatorException {
        if (!UsuarioConectadoSingleton.INSTANCE.isConectado())
            throw new ValidatorException("Usuario não está conectado!");
    }
}
