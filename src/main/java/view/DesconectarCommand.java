package view;

import exception.ValidatorException;
import validation.DesconectadoValidation;
import validation.UsuarioConectadoSingleton;

public class DesconectarCommand implements Command{
    private DesconectadoValidation desconectadoValidation;

    public DesconectarCommand() {
        this.desconectadoValidation = new DesconectadoValidation();
    }

    @Override
    public void execute() {
        try {
            desconectadoValidation.valida(null);
            UsuarioConectadoSingleton.INSTANCE.desconectar();
            System.out.println("Desconectado com sucesso!");
        }catch (ValidatorException e){
            System.out.println(e.getMessage());
        }
    }
}
