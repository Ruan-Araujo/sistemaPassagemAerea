package repository;

public class DAOSingleton {
    public static final DAOSingleton INSTANCE = new DAOSingleton();
    private ReservasDAO reservasDAO = new ReservasDAO();
    private ReservasDAO rotasDAO = new ReservasDAO();
    private ReservasDAO usuarioDAO = new ReservasDAO();


    private DAOSingleton(){
    }

    public ReservasDAO getReservasDAO(){
        return reservasDAO;
    }
}
