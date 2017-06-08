package programm;

import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

/**
 * Created by kevin on 07.06.2017.
 * Ein programm.Block ist eine Liste von X Fragen, die zusammen gehören. (Z.B. nur Mathematik additionsaufgaben)
 */

public class Block extends AsyncTask<String,Integer,String> {

    ArrayList<Question> questions = null;

    public Block(){
        questions = new ArrayList<Question>();
    }

    @Override
    protected String doInBackground(String... strings) {

        return Lib.readUrl("http://thebest.sysgame.de/run.cgi/getMathBlock");
    }

    protected void onPostExecute(String result) {
        stringToJSON(result);
        System.out.println("Done-Loading: "+result);

    }

    private void stringToJSON(String jsonStr){
        System.out.println(jsonStr);

        if (jsonStr != null) {
            try {
                JSONArray jsonArray = new JSONArray(jsonStr);
                System.out.println(jsonArray.toString());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    questions.add(new Question(
                            jsonObject.getString("questionText"),
                            jsonObject.getString("questionType"),
                            jsonObject.getInt("answerCount"),
                            jsonObject.getDouble("answerMax"),
                            jsonObject.getDouble("answerMin")
                    ));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        System.out.println(toString());

    }

    public ArrayList<Question> getQuestions(){return questions;}
    public String toString(){
        String result = "";
        for (int i =0;i<questions.size();i++){
            result += questions.get(i).toString();
        }
        return result;
    }
}
