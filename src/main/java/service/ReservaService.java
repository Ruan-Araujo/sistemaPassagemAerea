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
                .filter(e -> e.equals(user))
                .findFirst()
                .orElse(null);
    }
}