package view;

import service.CadUsuarioService;

public class CadUsuarioCommand implements Command{
    private CadUsuarioService cadUsuarioService;

    public CadUsuarioCommand() {
        this.cadUsuarioService = new CadUsuarioService();
    }

    @Override
    public void execute() {
    }
}
