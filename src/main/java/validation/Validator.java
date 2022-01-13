package validation;

import Exception.ValidatorException;

public interface Validator<T> {
    void valida(T objeto) throws ValidatorException;
}
