package programm;

/**
 * Created by kevin on 07.06.2017.
 * In der programm.Lib stehen hilfsmethoden, die von mehrern Instanzen verwendet werden. Diese Mehtoden müssen nich nicht instanziiert werden.
 */
import java.net.URL;
import java.net.*;
import java.io.*;

public class Lib {

    public static String readUrl(String urlString) {
        String result = "";
        URL url = null;
        try {
            url = new URL("http://thebest.sysgame.de/run.cgi/getMathBlock");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                result += inputLine;
                System.out.println(inputLine);
            }
            in.close();

        } catch (MalformedURLException e) {
            result+=e.getMessage();
            e.printStackTrace();
        } catch (IOException e) {
            result+=e.getMessage();
            e.printStackTrace();
        }
        System.out.print(result);
        return result;
    }
}
