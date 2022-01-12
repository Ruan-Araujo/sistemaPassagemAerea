package service;

import model.Reserva;
import model.Users;
import repository.Reader;

import java.util.List;

public class ReservaService {
    private Reader reader = new Reader();

    public List<Reserva> listarReserva(){
        return reader.listarReservas();
    }

    public Reserva getReservaById(Integer id){
        return reader.listarReservas().stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Reserva getReservaByUser(Users user){
        return reader.listarReservas().stream()
                .filter(e -> e.equals(user))
                .findFirst()
                .orElse(null);
    }
}
