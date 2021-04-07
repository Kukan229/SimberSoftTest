import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        File text = new File("C:\\text.html");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ссылку на вэб страницу");
        String str = scanner.nextLine();
        URL adress = new URL (str);
        new Loader(adress,text);
        new Counter(text);
    }
}
