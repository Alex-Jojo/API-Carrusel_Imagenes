import com.google.gson.Gson;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main {
    private static final String URL_1 = "https://dog.ceo/api/breed/";
    private static final String URL_2 = "/images/random/";

    public static void main(String[] args) {
        int n = 2;
        if (args.length != 0) {
            n = Integer.parseInt(args[0]);
        }

        String[] razas = {"husky","chihuahua","doberman","pitbull","akita","boxer","dhole","kelpie","affenpinscher",
                            "african","basenji","havanese","mix","saluki","puggle","sharpei","tervuren","vizsla"};
        String tipo = String.valueOf(JOptionPane.showInputDialog(null,
                "Escoja una raza de perros: ",
                "Razas", JOptionPane.QUESTION_MESSAGE, null, razas, "Husky"));


        Dogs response = query(n, tipo);
        ArrayList<String> urls = response.getMensaje();

        SwingUtilities.invokeLater(()->{
            ImageSlideShow frame = new ImageSlideShow(urls);
            frame.setSize(100,30);
            frame.setVisible(true);
        });
    }
    public static Dogs query(int n, String tipo) {
        Dogs response = null;
        try {
            String apiUrl = URL_1 + tipo + URL_2 + n;
            URL url = new URL(apiUrl);

            try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
                StringBuilder jsonText = new StringBuilder();
                String line;

                while ((line = in.readLine()) != null) {
                    jsonText.append(line);
                }

                Gson gson = new Gson();
                response = gson.fromJson(jsonText.toString(), Dogs.class);
            } catch (IOException e) {
                throw new RuntimeException("Error al leer la respuesta de la API: " + e.getMessage(), e);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("URL de la API no válida: " + e.getMessage(), e);
        }
        return response;
    }
}