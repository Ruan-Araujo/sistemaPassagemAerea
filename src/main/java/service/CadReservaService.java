package service;

import model.Reserva;

import java.util.ArrayList;
import java.util.List;

public class CadReservaService {
    List<Reserva> listaReservas = new ArrayList<>();

    public void cadastrarReserva(Reserva reserva) {
        listaReservas.add(reserva);
    }
}
