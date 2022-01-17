package validation;

import exception.ValidatorException;

public interface Validator<T> {
    void valida(T objeto) throws ValidatorException;
}
