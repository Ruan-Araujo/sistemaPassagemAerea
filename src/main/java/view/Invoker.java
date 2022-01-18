package view;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Invoker {
    public static Map<Integer, Class> comandos = new HashMap<>();

    static {
        comandos.put(1, ValidarUsuarioCommand.class);
        comandos.put(2, CadastrarUsuarioCommand.class);
        comandos.put(3, DeletarUsuarioCommand.class);
        comandos.put(4, ListarRotasCommand.class);
        comandos.put(5, RealizarReservaCommand.class);
        comandos.put(6, CancelarReservaCommand.class);
        comandos.put(7, ListarReservaCommand.class);
        comandos.put(8, DesconectarCommand.class);

    }
    
    public static void invoke(int command){
        try {
            Command c = (Command) comandos.get(command).getDeclaredConstructor().newInstance();
            c.execute();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}