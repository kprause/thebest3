package programm;

import android.os.AsyncTask;

/**
 * Created by kevin on 22.06.2017.
 */

public class Loader extends AsyncTask <String,Integer,String> {


    private Object object;

    public Loader(Object obj){
        object=obj;
    }

    @Override
    protected String doInBackground(String... strings) {

        if(strings.length>0) {
            if (strings[0].equals("login")) {
                Lib.login();
            }else if (object.getClass()==Block.class){
                Lib.readUrl(strings[1]);
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        if (object.getClass()==Block.class){
            Block b = (Block)object;
            b.loadResponse(s);
        }
    }
}
