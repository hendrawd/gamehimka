package himka.gamehimka;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import java.util.ArrayList;

import himka.gamehimka.question.Question;
import himka.gamehimka.question.QuestionListProvider;
import himka.gamehimka.question.beginner.BeginnerEasyQuestionListProvider;
import himka.gamehimka.question.master.MasterEasyQuestionListProvider;
import himka.gamehimka.question.moderate.ModerateEasyQuestionListProvider;
import himka.gamehimka.question.teenager.TeenagerEasyQuestionListProvider;

/**
 * @author hendrawd on 11/30/16
 */

public abstract class QuestionActivity extends Activity {

    private ArrayList<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QuestionListProvider questionListProvider;
        String level = getIntent().getStringExtra("level");
        switch (level) {
            case "beginner":
                questionListProvider = new BeginnerEasyQuestionListProvider();
                break;
            case "teenager":
                questionListProvider = new TeenagerEasyQuestionListProvider();
                break;
            case "moderate":
                questionListProvider = new ModerateEasyQuestionListProvider();
                break;
            default:
                //master
                questionListProvider = new MasterEasyQuestionListProvider();
                break;
        }
        questionList = questionListProvider.getQuestionList();
        createFragment();
    }

    private void createFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        QuestionFragment questionFragment = new QuestionFragment();
        fragmentTransaction.replace(R.id.fragment, questionFragment);
        fragmentTransaction.commit();
    }

    public Question getQuestion() {
        return questionList.remove(0);
    }
}
