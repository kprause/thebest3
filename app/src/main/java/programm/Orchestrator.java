package programm;

import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by kevin on 19.06.2017.
 * Es handelt sich hierbei um einen Singelton.
 */

public class Orchestrator extends AsyncTask <String,Integer,String> {

    private String sessionID;

    private boolean login = false;
    private ArrayList<Integer> blockList;
    private Block currentBlock;
    private Block nextBlock;
    private int currentBlockNum=0;
    private int nextBlockNum=1;
    private Question currentQuestion;

    public Question getNextQuestion(){

        if (currentBlock.getQuestions().size()>0){
            int randomNum = (int)(Math.random() * currentBlock.getQuestions().size());
            currentQuestion = currentBlock.getQuestions().get(randomNum);
        }else{

        }


        return getCurrentQuestion();
    }

    public void changeBlock(int newBlcok){
        if(newBlcok==-1){
            currentBlock=nextBlock;
            currentBlockNum = nextBlockNum;
            nextBlock=new Block(nextBlockNum);
        }
    }

    public Question getCurrentQuestion(){return currentQuestion;}

    private static Orchestrator instance;

    private Orchestrator(){

        //this.execute();
        currentBlock = new Block(currentBlockNum);
        nextBlock = new Block(nextBlockNum);
    }

    public void logout(){
        sessionID = "";
        login = false;
    }

    @Override
    protected String doInBackground(String... strings) {

        if(strings.length>0) {
            if (strings[0].equals("login")) {
                Lib.login();
            }
        }
        return null;
    }

    /* Die Klasse kann nicht direckt instanziiert werden, sondern muss über die get Insatance Methode
     * aufgerufen werden. Dadurch kann es in dem gesammtet Programm nur eine Instans der Klasse geben.
     * um sicherzustellen, das dies nicht durch Multithreads ausgehebelt wird muss die getOrchestrator
     * Methode synchronized durchgeführt werden, damit es keinen Parallelen Thread gibt und es nicht
     * zwei instansen geben kann. (kann bei häufigen getOrchestrator aufrufen zu einem Performanceproblem
     * führen.)
    */
    public static synchronized Orchestrator getOrchestrator(){
        if (instance==null){
            instance = new Orchestrator();
        }
        return instance;
    }

    public boolean getLoginStatus(){return login;}
}
