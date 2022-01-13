package view;

import service.RotasService;

public class ListarRotasCommand implements Command{

    RotasService rotasService = new RotasService();

    @Override
    public void execute() {
        System.out.println("Rotas disponíveis: ");
        rotasService.listarRotas().forEach(System.out::println);
    }
}
