package himka.gamehimka.question.master;

import java.util.ArrayList;

import himka.gamehimka.R;
import himka.gamehimka.question.Question;
import himka.gamehimka.question.QuestionListProvider;

/**
 * @author hendrawd on 11/29/16
 */

public class MasterEasyQuestionListProvider implements QuestionListProvider {

    private ArrayList<Question> questionList = new ArrayList<>();

    public MasterEasyQuestionListProvider() {
        questionList.add(createQuestion1());
        questionList.add(createQuestion2());
        questionList.add(createQuestion3());
        questionList.add(createQuestion4());
        questionList.add(createQuestion5());
    }

    private Question createQuestion5() {
        Question questionInput = new Question();
        questionInput.setQuestion("5. Berapakah jumlah bola berwarna kuning");
        questionInput.setQuestionImageResources(
                new int[]{
                        R.drawable.ic_question_balls,
                }
        );
        questionInput.setAnswer("9");
        questionInput.setType(Question.TYPE_INPUT);
        questionInput.setTime(5);
        return questionInput;
    }

    private Question createQuestion4() {
        Question questionMultipleSelection = new Question();
        questionMultipleSelection.setQuestion("4. Gambar untuk grafik 3x² - 5 adalah");
        questionMultipleSelection.setAnswerImageResources(new int[]{
                R.drawable.ic_question_graphic1,
                R.drawable.ic_question_graphic2,
        });
        questionMultipleSelection.setAnswer(0);
        questionMultipleSelection.setType(Question.TYPE_MULTIPLE_SELECTION);
        questionMultipleSelection.setUseSound(true);
        return questionMultipleSelection;
    }

    private Question createQuestion3() {
        Question questionInput = new Question();
        questionInput.setQuestion("3. Diketahui H = {k|x² -1 < x² + k < 2(x+1) , dengan x dan k bilangan bulat}.\n" +
                "Banyaknya himpunan bagian dari himpunan H adalah ");
        questionInput.setAnswer("!");//TODO belom ada jawaban
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion2() {
        Question questionMultipleSelection = new Question();
        questionMultipleSelection.setQuestion("2. Manakah yang termasuk pencerminan?");
        questionMultipleSelection.setAnswerImageResources(new int[]{
                R.drawable.ic_question_mirror1,
                R.drawable.ic_question_mirror2,
                R.drawable.ic_question_mirror3,
                R.drawable.ic_question_mirror4,
        });
        questionMultipleSelection.setAnswer(1);
        questionMultipleSelection.setType(Question.TYPE_MULTIPLE_SELECTION);
        return questionMultipleSelection;
    }

    private Question createQuestion1() {
        Question questionInput = new Question();
        questionInput.setQuestion("1. Berapakah banyak segitiga yang dapat dibentuk dari gambar ini? Clue: jumlahnya terdiri dari 4 angka.");
        questionInput.setQuestionImageResources(
                new int[]{
                        R.drawable.ic_question_build_triangle
                }
        );
        questionInput.setAnswer("1056");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    @Override
    public ArrayList<Question> getQuestionList() {
        return questionList;
    }
}
