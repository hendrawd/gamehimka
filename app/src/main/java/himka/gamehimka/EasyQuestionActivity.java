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
 * @author hendrawd on 11/29/16
 */

public class EasyQuestionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_question);

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
                questionListProvider = new MasterEasyQuestionListProvider();
                break;
        }
        ArrayList<Question> questionList = questionListProvider.getQuestionList();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        QuestionFragment questionFragment = new QuestionFragment();

        Bundle data = new Bundle();
        data.putParcelableArrayList("questionList", questionList);
        data.putParcelable("movie data", question);
        questionFragment.setArguments(data);

        fragmentTransaction.replace(R.id.fragment, questionFragment);
        fragmentTransaction.commit();
    }
}
