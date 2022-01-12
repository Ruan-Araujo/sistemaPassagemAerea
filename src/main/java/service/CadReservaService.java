package service;

import model.Reserva;
import repository.Reader;

public class CadReservaService {

    private Reader reader = new Reader();

    public void realizarReserva(Reserva reserva) {
        reader.adicionarReserva(reserva);
    }

    public void cancelarReserva(Reserva reserva) {
        for (Reserva reservas : reader.listarReservas()) {
            if (reservas.equals(reserva)){
                reader.listarReservas().remove(reserva);
            }
        }
    }
}
