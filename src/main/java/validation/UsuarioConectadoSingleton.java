package validation;

public class UsuarioConectadoSingleton {
    public static final UsuarioConectadoSingleton INSTANCE = new UsuarioConectadoSingleton();
    private boolean isConectado;

    private UsuarioConectadoSingleton(){
    }

    public Boolean isConectado(){
        return isConectado;
    }

    public void conectar(){
        this.isConectado = true;
    }
}
