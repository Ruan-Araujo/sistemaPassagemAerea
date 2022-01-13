package view;

import model.Reserva;
import model.Rotas;
import service.ReservaService;
import service.RotasService;
import validation.RealizarReservaValidation;
import validation.UsuarioConectadoSingleton;

import java.util.Scanner;

public class RealizarReservaCommand implements Command {
    private RealizarReservaValidation realizarReservaValidation;
    private ReservaService reservaService;
    private RotasService rotasService;
    private Scanner sc = new Scanner(System.in);

    public RealizarReservaCommand() {
        this.realizarReservaValidation = new RealizarReservaValidation();
        this.rotasService = new RotasService();
        this.reservaService = new ReservaService();
    }

    @Override
    public void execute() {
        if (!UsuarioConectadoSingleton.INSTANCE.isConectado()) {
            throw new RuntimeException("Usuario não esta conectado!");
        }
        System.out.println("Insira o ID da rota desejada:");
        int rotaId = sc.nextInt();
        Rotas rota = rotasService.getRotasById(rotaId);
        try {
            realizarReservaValidation.valida(rota);
            reservaService.realizarReserva(cadastrarReserva(rota));
            System.out.println("Reserva realizada com sucesso!");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }

    public Reserva cadastrarReserva(Rotas rota) {
        System.out.println("Insira o metodo de pagamento:");
        String metodoDePagamento = sc.nextLine();
        System.out.println("Insira a quantidade de passagens desejadas:");
        int quantidadePassagens = sc.nextInt();
        return new Reserva(1, rota, metodoDePagamento, quantidadePassagens);
    }
}


