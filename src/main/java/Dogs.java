import java.util.ArrayList;

public class Dogs {
    public ArrayList<String> message;
    public String status;

    public Dogs(ArrayList<String> message, String status) {
        this.message = message;
        this.status = status;
    }


    public ArrayList<String> getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
