import java.util.ArrayList;

public class Dogs {
    public ArrayList<String> mensaje;
    public String estado;

    public Dogs(ArrayList<String> message, String status) {
        this.mensaje = message;
        this.estado = status;
    }


    public ArrayList<String> getMensaje() {
        return mensaje;
    }


}
