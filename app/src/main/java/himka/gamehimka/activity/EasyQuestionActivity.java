package himka.gamehimka.activity;

import android.os.Bundle;

import himka.gamehimka.R;

/**
 * @author hendrawd on 11/29/16
 */

public class EasyQuestionActivity extends QuestionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_easy_question);
        setSubLevel("easy");
        super.onCreate(savedInstanceState);
    }
}
