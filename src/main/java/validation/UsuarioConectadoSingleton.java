package validation;

public class UsuarioConectadoSingleton {
    public static final UsuarioConectadoSingleton INSTANCE = new UsuarioConectadoSingleton();
    private boolean isConectado;
    private Integer usuarioId;

    private UsuarioConectadoSingleton(){
    }

    public Boolean isConectado(){
        return isConectado;
    }

    public void conectar(Integer usuarioId){
        this.usuarioId = usuarioId;
        this.isConectado = true;
    }

    public void desconectar(){
        this.usuarioId = null;
        this.isConectado = false;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }
}
