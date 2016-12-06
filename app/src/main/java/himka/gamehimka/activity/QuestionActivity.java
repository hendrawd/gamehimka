package himka.gamehimka.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import himka.gamehimka.R;
import himka.gamehimka.fragment.QuestionFragment;
import himka.gamehimka.question.Question;
import himka.gamehimka.question.QuestionListProvider;
import himka.gamehimka.question.beginner.BeginnerEasyQuestionListProvider;
import himka.gamehimka.question.beginner.BeginnerHardQuestionListProvider;
import himka.gamehimka.question.master.MasterEasyQuestionListProvider;
import himka.gamehimka.question.master.MasterHardQuestionListProvider;
import himka.gamehimka.question.moderate.ModerateEasyQuestionListProvider;
import himka.gamehimka.question.moderate.ModerateHardQuestionListProvider;
import himka.gamehimka.question.teenager.TeenagerEasyQuestionListProvider;
import himka.gamehimka.question.teenager.TeenagerHardQuestionListProvider;
import himka.gamehimka.util.PreferenceHelper;
import himka.gamehimka.view.CustomToast;

/**
 * @author hendrawd on 11/30/16
 */

public abstract class QuestionActivity extends Activity {

    private ArrayList<Question> questionList;
    private int index = 0;
    private int score = 0;
    private String subLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView buttonBack = (ImageView) findViewById(R.id.button_back);
        ImageView buttonHome = (ImageView) findViewById(R.id.button_home);
        setScore(0);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToLevelSelectionActivity = new Intent(QuestionActivity.this, LevelSelectionActivity.class);
                startActivity(goToLevelSelectionActivity);
                finish();
            }
        });

        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHomeActivity();
                finish();
            }
        });

        QuestionListProvider questionListProvider;
        String level = getIntent().getStringExtra("level");
        switch (level) {
            case "beginner":
                if (subLevel.equals("easy")) {
                    questionListProvider = new BeginnerEasyQuestionListProvider();
                } else {
                    questionListProvider = new BeginnerHardQuestionListProvider();
                }
                break;
            case "teenager":
                if (subLevel.equals("easy")) {
                    questionListProvider = new TeenagerEasyQuestionListProvider();
                } else {
                    questionListProvider = new TeenagerHardQuestionListProvider();
                }
                break;
            case "moderate":
                if (subLevel.equals("easy")) {
                    questionListProvider = new ModerateEasyQuestionListProvider();
                } else {
                    questionListProvider = new ModerateHardQuestionListProvider();
                }
                break;
            default:
                //master
                if (subLevel.equals("easy")) {
                    questionListProvider = new MasterEasyQuestionListProvider();
                } else {
                    questionListProvider = new MasterHardQuestionListProvider();
                }
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
        return questionList.get(index);
    }

    public void createNextQuestion(int score) {
        this.score += score;
        setScore(this.score);
        index++;
        if (index < questionList.size()) {
            createFragment();
        } else {
            if (this.score > 30) {
                PreferenceHelper.setLevel(this, PreferenceHelper.getLevel(this) + 1);
                CustomToast.show(this, "Pertanyaan habis, skor kamu adalah: " + this.score + ". Kamu berhasil naik level");
            } else {
                CustomToast.show(this, "Pertanyaan habis, skor kamu adalah: " + this.score + ". Kamu gagal naik level");
            }

            goToHomeActivity();
            finish();
        }
    }

    protected void setSubLevel(String subLevel) {
        this.subLevel = subLevel;
    }

    private void goToHomeActivity() {
        Intent goToHomeActivity = new Intent(QuestionActivity.this, HomeActivity.class);
        startActivity(goToHomeActivity);
    }

    private void setScore(int score) {
        ((TextView) findViewById(R.id.tv_score)).setText(getString(R.string.score, score));
    }

    public void setTimeLeft(String timeLeft) {
        ((TextView) findViewById(R.id.tv_time)).setText(timeLeft);
    }
}
