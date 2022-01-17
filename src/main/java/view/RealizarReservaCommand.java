package view;

import exception.ValidatorException;
import model.Reserva;
import model.Rotas;
import model.Users;
import service.ReservaService;
import service.RotasService;
import service.UsuarioService;
import validation.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class RealizarReservaCommand implements Command {
    private RealizarReservaValidation realizarReservaValidation;
    private RotaValidation rotaValidation;
    private ReservaService reservaService;
    private RotasService rotasService;
    private Scanner sc = new Scanner(System.in);
    private UsuarioService usuarioService;
    private NotConectadoValidation notConectadoValidation;

    public RealizarReservaCommand() {
        this.realizarReservaValidation = new RealizarReservaValidation();
        this.rotaValidation = new RotaValidation();
        this.rotasService = new RotasService();
        this.reservaService = new ReservaService();
        this.usuarioService = new UsuarioService();
        this.notConectadoValidation = new NotConectadoValidation();
    }

    @Override
    public void execute() {
        try {
            notConectadoValidation.valida(null);
            System.out.println("Insira o ID da rota desejada:");
            int rotaId = sc.nextInt();
            Rotas rota = rotasService.getRotasById(rotaId);
            rotaValidation.valida(rota);
            Reserva reserva = cadastrarReserva(rota);
            realizarReservaValidation.valida(reserva);
            reservaService.realizarReserva(reserva);
            System.out.println("Reserva realizada com sucesso!");
        } catch (ValidatorException e) {
            System.out.println(e.getMessage());
        }
    }

    public Reserva cadastrarReserva(Rotas rota) {
        System.out.println("Insira o metodo de pagamento:");
        String metodoDePagamento = sc.next();
        System.out.println("Insira a quantidade de passagens desejadas:");
        int quantidadePassagens = sc.nextInt();
        Integer reservaId = reservaService.getIdIterator();
        Integer userid = UsuarioConectadoSingleton.INSTANCE.getUserId();
        Users users = usuarioService.getUserById(userid);
        Reserva reserva = new Reserva(reservaId, rota, metodoDePagamento, quantidadePassagens, users);
        System.out.println("Valor total: " + reserva.getValorTotal());
        System.out.println("Deseja confirmar a compra? Pressione Y para confirmar!");
        if (sc.next().equalsIgnoreCase("y")){
            return reserva;
        }else {
            return null;
        }
    }
}


