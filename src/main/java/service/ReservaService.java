package service;

import model.Reserva;
import model.Users;
import repository.DAOSingleton;
import repository.ReservasDAO;

import java.util.List;

public class ReservaService {

    private ReservasDAO dao;

    public ReservaService() {
        this.dao = DAOSingleton.INSTANCE.getReservasDAO();
    }
    public void realizarReserva(Reserva reserva) {
        dao.adicionarReserva(reserva);
    }

    public void cancelarReserva(Reserva reserva) {
        dao.deletarReserva(reserva);
    }

    public List<Reserva> listarReserva(){
        return dao.listarReservas();
    }

    public Reserva getReservaById(Integer id){
        return dao.listarReservas().stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Reserva getReservaByUser(Users user){
        return dao.listarReservas().stream()
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
