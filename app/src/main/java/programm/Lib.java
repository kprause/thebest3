package programm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by kevin on 07.06.2017.
 * In der programm.Lib stehen hilfsmethoden, die von mehrern Instanzen verwendet werden. Diese Mehtoden müssen nich nicht instanziiert werden.
 */

public class Lib {

    public static String readUrl(String urlString) {
        String result="";
        URL url;
        try {
            url = new URL(urlString);
            System.out.println(url.toString());
            URLConnection urlCon = url.openConnection();
            System.out.println("Alive!");
            InputStreamReader reader = new InputStreamReader(urlCon.getInputStream());
            System.out.println("Still alive");
            BufferedReader in = new BufferedReader(reader);
            System.out.println("STILL ALIVE!");
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                result+=inputLine;
            }
            in.close();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e.toString());
        }
        System.out.println(result);
        return result;
    }

}
