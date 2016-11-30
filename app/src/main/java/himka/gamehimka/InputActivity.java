package himka.gamehimka;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import himka.gamehimka.view.CustomToast;

/**
 * @author hendrawd on 11/29/16
 */

public class InputActivity extends Activity {

    private TextView tvQuestion;
    private EditText etAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_question_input);

        etAnswer = (EditText) findViewById(R.id.et_answer);
        tvQuestion = (TextView) findViewById(R.id.tv_question);

        Intent intent = getIntent();

        String question = intent.getStringExtra("question");
        tvQuestion.setText(question);

        String answer = intent.getStringExtra("answer");

        //button jawab
        if (TextUtils.isEmpty(etAnswer.getText())) {
            CustomToast.show(this, "Silakan isi jawaban");
        }
    }
}
