package service;

import model.Reserva;
import model.Users;
import repository.ReservasDAO;

import java.util.List;

public class ReservaService {

    private ReservasDAO reservasDAO;

    public ReservaService() {
        this.reservasDAO = new ReservasDAO();
    }

    public void realizarReserva(Reserva reserva) {
        reservasDAO.adicionarReserva(reserva);
    }

    public void cancelarReserva(Reserva reserva) {
        reservasDAO.deletarReserva(reserva);
    }

    public List<Reserva> listarReserva(){
        return reservasDAO.listarReservas();
    }

    public Reserva getReservaById(Integer id){
        return reservasDAO.listarReservas().stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Reserva getReservaByUser(Users user){
        return reservasDAO.listarReservas().stream()
                .filter(e -> e.getUsuario().equals(user))
                .findFirst()
                .orElse(null);
    }

    public Integer getIdIterator(){
        List<Reserva> listaReserva = listarReserva();
        int sizeReservas = listaReserva.size();
        if (sizeReservas == 0){
            return 1;
        }else {
            Integer id = listaReserva.get(sizeReservas - 1).getId() + 1;
            return id;
        }
    }
}
