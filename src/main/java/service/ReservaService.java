package service;

import model.Reserva;
import model.Usuario;
import repository.ReservasDAO;

import java.util.List;
import java.util.stream.Collectors;

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

    public void cancelarReservasByUsuario(Usuario usuario) {
        List<Reserva> reservas = getReservasByUsuario(usuario);
        reservas.forEach(e -> reservasDAO.deletarReserva(e));
    }

    public List<Reserva> listarReserva(){
        return reservasDAO.listarReservas();
    }

    public Reserva getReservaById(Integer id, Usuario usuario){
        return getReservasByUsuario(usuario).stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Reserva> getReservasByUsuario(Usuario usuario){
        return reservasDAO.listarReservas().stream()
                .filter(e -> e.getUsuario().equals(usuario))
                .collect(Collectors.toList());
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
