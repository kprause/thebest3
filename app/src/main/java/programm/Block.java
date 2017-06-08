package programm;

import android.os.AsyncTask;

/**
 * Created by kevin on 07.06.2017.
 * Ein programm.Block ist eine Liste von X Fragen, die zusammen gehören. (Z.B. nur Mathematik additionsaufgaben)
 */

public class Block extends AsyncTask<String,Integer,String> {

    @Override
    protected String doInBackground(String... strings) {

        return Lib.readUrl("http://thebest.sysgame.de/run.cgi/getMathBlock");
    }

    protected void onPostExecute(String result) {

        System.out.println("Done-Loading: "+result);

    }

}
