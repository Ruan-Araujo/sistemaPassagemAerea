package service;

import model.Reserva;
import repository.DAOSingleton;
import repository.ReservasDAO;


public class CadReservaService {

    private ReservasDAO dao;

    public CadReservaService() {
        this.dao = DAOSingleton.INSTANCE.getReservasDAO();
    }

    public void realizarReserva(Reserva reserva) {
        dao.adicionarReserva(reserva);
    }

    public void cancelarReserva(Reserva reserva) {
        for (Reserva reservas : dao.listarReservas()) {
            if (reservas.equals(reserva)){
                dao.listarReservas().remove(reserva);
            }
        }
    }
}
