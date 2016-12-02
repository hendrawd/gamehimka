package himka.gamehimka.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import himka.gamehimka.R;
import himka.gamehimka.view.CustomToast;
import himka.gamehimka.view.PredicateLayout;

/**
 * @author hendrawd on 11/29/16
 */

public class MultipleImageSelectionActivity extends Activity {

    private PredicateLayout answerContainer;
    private TextView tvQuestion;
    private int[] resourceIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_question_multiple_image_selection);

        answerContainer = (PredicateLayout) findViewById(R.id.answer_container);
        tvQuestion = (TextView) findViewById(R.id.tv_question);

        Intent intent = getIntent();

        String question = intent.getStringExtra("question");
        tvQuestion.setText(question);

        resourceIds = intent.getIntArrayExtra("answers");

        final int answerIndex = intent.getIntExtra("answerIndex", 0);

        for (int i = 0; i < resourceIds.length; i++) {
            LayoutInflater inflater = LayoutInflater.from(this);
            ImageView imageView = (ImageView) inflater.inflate(R.layout.layout_answer_image, null);
            imageView.setImageResource(resourceIds[i]);

            final int finalI = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (finalI == answerIndex) {
                        CustomToast.show(MultipleImageSelectionActivity.this, "Jawaban kamu benar!");
                    } else {
                        CustomToast.show(MultipleImageSelectionActivity.this, "Jawaban kamu salah!");
                    }
                }
            });
            answerContainer.addView(imageView);
        }
    }
}
