package view;

import validation.UsuarioConectadoSingleton;

public class DesconectarCommand implements Command{

    @Override
    public void execute() {
        if (UsuarioConectadoSingleton.INSTANCE.isConectado())
            UsuarioConectadoSingleton.INSTANCE.desconectar();
        System.out.println("Desconectado com sucesso!");
    }
}
