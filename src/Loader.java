import org.w3c.dom.css.Counter;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Loader { //ДАнный класс скачивает вэб страницу по средствам HTTP запроса и сохраняет её в html формате
    public Loader(URL a,File b) throws IOException {
        String input = null;
        FileWriter fw = new FileWriter(b);
        HttpURLConnection con = (HttpURLConnection) a.openConnection();
        InputStreamReader html_in = new InputStreamReader(con.getInputStream());
        BufferedReader br = new BufferedReader(html_in);
        while ((input = br.readLine()) != null) {
            fw.write(input);
        }
        br.close();
        fw.close();
    }

}
