package himka.gamehimka.fragment;

import android.app.Fragment;
import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import himka.gamehimka.R;
import himka.gamehimka.activity.QuestionActivity;
import himka.gamehimka.question.Question;
import himka.gamehimka.util.Logger;
import himka.gamehimka.util.TextToSpeechHelper;
import himka.gamehimka.view.CustomToast;
import himka.gamehimka.view.PredicateLayout;

/**
 * @author hendrawd on 11/29/16
 */

public class QuestionFragment extends Fragment {

    private TextToSpeechHelper textToSpeechHelper;

    @Override
    public void onStop() {
        super.onStop();
        if (textToSpeechHelper != null) {
            textToSpeechHelper.stop();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mainContent = null;
        Question question = ((QuestionActivity) getActivity()).getQuestion();
        if (question.isUseSound()) {
            if (!TextUtils.isEmpty(question.getQuestion())) {
                if (textToSpeechHelper == null) {
                    textToSpeechHelper = new TextToSpeechHelper();
                }
                textToSpeechHelper.speak(getActivity(), question.getQuestion());
            }
        }
        switch (question.getType()) {
            case Question.TYPE_INPUT:
                mainContent = createInputFragment(inflater, container, question);
                break;
            case Question.TYPE_MULTIPLE_SELECTION:
                mainContent = createMultipleSelectionFragment(inflater, container, question);
                break;
            case Question.TYPE_DRAG_AND_DROP:
                mainContent = createDragAndDropFragment(inflater, container, question);
                break;
        }
        return mainContent;
    }

    private View createInputFragment(LayoutInflater inflater, ViewGroup container, final Question question) {
        View mainContent = inflater.inflate(R.layout.fragment_question_input, container, false);

        final EditText etAnswer = (EditText) mainContent.findViewById(R.id.et_answer);
        TextView tvQuestion = (TextView) mainContent.findViewById(R.id.tv_question);
        PredicateLayout questionContainer = (PredicateLayout) mainContent.findViewById(R.id.question_container);
        Button bAnswer = (Button) mainContent.findViewById(R.id.b_answer);

        tvQuestion.setText(question.getQuestion());

        int[] resourceIds = question.getImageResources();
        if (resourceIds != null) {
            for (int resourceId : resourceIds) {
                ImageView imageView = (ImageView) inflater.inflate(R.layout.layout_simple_image, null);
                imageView.setImageResource(resourceId);
                questionContainer.addView(imageView);
            }
        }

        bAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userAnswer = etAnswer.getText().toString();
                if (TextUtils.isEmpty(userAnswer)) {
                    CustomToast.show(getActivity(), getString(R.string.please_answer));
                } else {
                    //cek jawaban
                    userAnswer = userAnswer.trim().replace(" ", "").toLowerCase();
                    String theRightAnswer = question.getAnswer().toString().trim().replace(" ", "").toLowerCase();
                    if (theRightAnswer.equals(userAnswer)) {
                        CustomToast.show(getActivity(), getString(R.string.answer_right));
                        ((QuestionActivity) getActivity()).createNextQuestion(10);
                    } else {
                        CustomToast.show(getActivity(), getString(R.string.answer_wrong));
                        ((QuestionActivity) getActivity()).createNextQuestion(0);
                    }
                }
            }
        });

        return mainContent;
    }

    private View createMultipleSelectionFragment(LayoutInflater inflater, ViewGroup container, Question question) {
        View mainContent = inflater.inflate(R.layout.fragment_question_multiple_image_selection, container, false);

        PredicateLayout answerContainer = (PredicateLayout) mainContent.findViewById(R.id.answer_container);
        TextView tvQuestion = (TextView) mainContent.findViewById(R.id.tv_question);

        int[] resourceIds = question.getImageResources();

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
                        CustomToast.show(getActivity(), getString(R.string.answer_right));
                        ((QuestionActivity) getActivity()).createNextQuestion(10);
                    } else {
                        CustomToast.show(getActivity(), getString(R.string.answer_wrong));
                        ((QuestionActivity) getActivity()).createNextQuestion(0);
                    }
                }
            });
            answerContainer.addView(imageView);
        }

        return mainContent;
    }

    private View createDragAndDropFragment(LayoutInflater inflater, ViewGroup container, Question question) {
        View mainContent = inflater.inflate(R.layout.fragment_question_drag_drop, container, false);

        TextView tvQuestion = (TextView) mainContent.findViewById(R.id.tv_question);
        PredicateLayout questionContainer = (PredicateLayout) mainContent.findViewById(R.id.question_container);
        final PredicateLayout answerContainer = (PredicateLayout) mainContent.findViewById(R.id.answer_container);
        Button bAnswer = (Button) mainContent.findViewById(R.id.b_answer);

        int[] resourceIds = question.getImageResources();

        tvQuestion.setText(question.getQuestion());

        View.OnLongClickListener dragTrigger = getDragTrigger();
        View.OnDragListener dragListener = getDragListener();

        int i = 0;
        for (; i < resourceIds.length / 2; i++) {
            ImageView imageView = (ImageView) inflater.inflate(R.layout.layout_image_drag_and_drop, null);
            imageView.setTag(resourceIds[i]);
            imageView.setImageResource(resourceIds[i]);
            imageView.setOnLongClickListener(dragTrigger);

            questionContainer.addView(imageView);
        }

        for (; i < resourceIds.length; i++) {
            ImageView imageView = (ImageView) inflater.inflate(R.layout.layout_image_drag_and_drop, null);
            imageView.setBackgroundResource(resourceIds[i]);
            imageView.setOnDragListener(dragListener);

            answerContainer.addView(imageView);
        }

        final int[] answers = (int[]) question.getAnswer();
        bAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAnswerCorrect = true;
                for (int j = 0; j < answerContainer.getChildCount(); j++) {
                    ImageView answerView = (ImageView) answerContainer.getChildAt(j);
                    if (answerView.getTag() == null) {
                        CustomToast.show(getActivity(), getString(R.string.please_answer));
                        return;
                    }
                    int resourceId = (int) answerView.getTag();
                    if (answers[j] != resourceId) {
                        isAnswerCorrect = false;
                    }
                }
                if (isAnswerCorrect) {
                    CustomToast.show(getActivity(), getString(R.string.answer_right));
                    ((QuestionActivity) getActivity()).createNextQuestion(10);
                } else {
                    CustomToast.show(getActivity(), getString(R.string.answer_wrong));
                    ((QuestionActivity) getActivity()).createNextQuestion(0);
                }
            }
        });

        return mainContent;
    }

    @SuppressWarnings("deprecation")
    private View.OnLongClickListener getDragTrigger() {
        return new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                ClipData.Item item = new ClipData.Item(view.getTag() + "");
                ClipData dragData = new ClipData(view.getTag() + "", new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN}, item);
                View.DragShadowBuilder viewShadow = new View.DragShadowBuilder(view);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    view.startDragAndDrop(dragData, viewShadow, null, 0);
                } else {
                    view.startDrag(dragData, viewShadow, null, 0);
                }
                return false;
            }
        };
    }

    private View.OnDragListener getDragListener() {
        return new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                ImageView currentImageView = (ImageView) view;

                final int dragEventAction = dragEvent.getAction();

                switch (dragEventAction) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        if (dragEvent.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                            currentImageView.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                            return true;
                        }
                        return false;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        currentImageView.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_ATOP);
                        return true;

                    case DragEvent.ACTION_DRAG_LOCATION:
                        return true;

                    case DragEvent.ACTION_DRAG_EXITED:
                        currentImageView.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                        return true;

                    case DragEvent.ACTION_DROP:
                        ClipData.Item item = dragEvent.getClipData().getItemAt(0);
                        String dragData = item.getText().toString();
                        Logger.d("Drag and drop", "Dragged data is " + dragData);
                        currentImageView.clearColorFilter();
                        int imageResource = Integer.valueOf(dragData);
                        currentImageView.setImageResource(imageResource);
                        currentImageView.setTag(imageResource);
                        return true;

                    case DragEvent.ACTION_DRAG_ENDED:
                        currentImageView.getBackground().clearColorFilter();

                        if (dragEvent.getResult()) {
                            Logger.d("Drag and drop", "The drop was handled.");
                        } else {
                            Logger.d("Drag and drop", "The drop didn't work.");
                        }
                        return true;

                    default:
                        Logger.d("Drag and drop", "Unknown action type received by OnDragListener.");
                }
                return false;
            }
        };
    }

}
