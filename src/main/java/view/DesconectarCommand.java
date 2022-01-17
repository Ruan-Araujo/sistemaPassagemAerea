package view;

import exception.ValidatorException;
import validation.IsConectadoValidation;
import validation.NotConectadoValidation;
import validation.UsuarioConectadoSingleton;

public class DesconectarCommand implements Command{
    private NotConectadoValidation notConectadoValidation;

    public DesconectarCommand() {
        this.notConectadoValidation = new NotConectadoValidation();
    }

    @Override
    public void execute() {
        try {
            notConectadoValidation.valida(null);
            UsuarioConectadoSingleton.INSTANCE.desconectar();
            System.out.println("Desconectado com sucesso!");
        }catch (ValidatorException e){
            System.out.println(e.getMessage());
        }
    }
}
