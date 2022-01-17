package validation;

public class UsuarioConectadoSingleton {
    public static final UsuarioConectadoSingleton INSTANCE = new UsuarioConectadoSingleton();
    private boolean isConectado;
    private Integer userId;

    private UsuarioConectadoSingleton(){
    }

    public Boolean isConectado(){
        return isConectado;
    }

    public void conectar(Integer userId){
        this.userId = userId;
        this.isConectado = true;
    }

    public void desconectar(){
        this.userId = null;
        this.isConectado = false;
    }

    public Integer getUserId() {
        return userId;
    }
}
