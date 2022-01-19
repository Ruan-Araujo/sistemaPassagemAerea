package view;

import exception.ValidatorException;
import model.Usuario;
import service.UsuarioService;
import validation.*;

public class DeletarUsuarioCommand implements Command{
    private UsuarioService usuarioService;
    private DesconectadoValidation desconectadoValidation;
    private DeletarUsuarioValidation deletarUsuarioValidation;
    private CancelarReservaCommand cancelarReservaCommand;

    public DeletarUsuarioCommand() {
        this.usuarioService = new UsuarioService();
        this.desconectadoValidation= new DesconectadoValidation();
        this.deletarUsuarioValidation = new DeletarUsuarioValidation();
        this.cancelarReservaCommand = new CancelarReservaCommand();
    }

    @Override
    public void execute() {
        try {
            Integer usuarioId = UsuarioConectadoSingleton.INSTANCE.getUsuarioId();
            Usuario usuarioConectado = usuarioService.getUsuarioById(usuarioId);
            desconectadoValidation.valida(null);
            deletarUsuarioValidation.valida(usuarioConectado);
            cancelarReservaCommand.execute();
            usuarioService.deletarUsuario(usuarioConectado);
            UsuarioConectadoSingleton.INSTANCE.desconectar();
            System.out.println("Conta excluida com sucesso!");
        } catch (ValidatorException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
