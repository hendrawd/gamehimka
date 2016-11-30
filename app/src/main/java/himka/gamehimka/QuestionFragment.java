package himka.gamehimka;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import himka.gamehimka.question.Question;
import himka.gamehimka.view.CustomToast;
import himka.gamehimka.view.PredicateLayout;

/**
 * @author hendrawd on 11/29/16
 */

public class QuestionFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mainContent = null;
        Question question = ((QuestionActivity) getActivity()).getQuestion();
        switch (question.getType()) {
            case Question.TYPE_INPUT:
                mainContent = createInputFragment(inflater, container, question);
                break;
            case Question.TYPE_MULTIPLE_SELECTION:
                mainContent = createMultipleSelectionFragment(inflater, container, question);
                break;
        }
        return mainContent;
    }

    private View createInputFragment(LayoutInflater inflater, ViewGroup container, Question question) {
        View mainContent = inflater.inflate(R.layout.fragment_question_input, container, false);
        EditText etAnswer = (EditText) mainContent.findViewById(R.id.et_answer);
        TextView tvQuestion = (TextView) mainContent.findViewById(R.id.tv_question);
        tvQuestion.setText(question.getQuestion());
        //TODO tambah button submit dan cek jawaban di etAnswer sama dengan di question.getAnswer ato engga
        return mainContent;
    }

    private View createMultipleSelectionFragment(LayoutInflater inflater, ViewGroup container, Question question) {
        View mainContent = inflater.inflate(R.layout.fragment_question_multiple_image_selection, container, false);
        PredicateLayout answerContainer = (PredicateLayout) mainContent.findViewById(R.id.answer_container);
        TextView tvQuestion = (TextView) mainContent.findViewById(R.id.tv_question);

        int[] resourceIds = question.getSelection();

        final int answerIndex = (int) question.getAnswer();

        tvQuestion.setText(question.getQuestion());
        for (int i = 0; i < resourceIds.length; i++) {
            ImageView imageView = (ImageView) inflater.inflate(R.layout.layout_answer_image, null);
            imageView.setImageResource(resourceIds[i]);

            final int finalI = i;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (finalI == answerIndex) {
                        CustomToast.show(getActivity(), "Jawaban kamu benar!");
                    } else {
                        CustomToast.show(getActivity(), "Jawaban kamu salah!");
                    }
                }
            });
            answerContainer.addView(imageView);
        }
        return mainContent;
    }
}
