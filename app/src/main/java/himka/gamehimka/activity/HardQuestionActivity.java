package himka.gamehimka.activity;

import android.os.Bundle;

import himka.gamehimka.R;

/**
 * @author hendrawd on 11/29/16
 * TODO tambah skor di kanan atas
 */

public class HardQuestionActivity extends QuestionActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_hard_question);
        setSubLevel("hard");
        super.onCreate(savedInstanceState);
    }
}
