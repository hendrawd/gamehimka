package himka.gamehimka.question.master;

import java.util.ArrayList;

import himka.gamehimka.R;
import himka.gamehimka.question.Question;
import himka.gamehimka.question.QuestionListProvider;

/**
 * @author hendrawd on 11/29/16
 */

public class MasterHardQuestionListProvider implements QuestionListProvider {

    private ArrayList<Question> questionList = new ArrayList<>();

    public MasterHardQuestionListProvider() {
        questionList.add(createQuestion1());
        questionList.add(createQuestion2());
        questionList.add(createQuestion3());
        questionList.add(createQuestion4());
        questionList.add(createQuestion5());
    }

    private Question createQuestion5() {
        Question questionInput = new Question();
        questionInput.setQuestion("5. Berapakah jumlah bola berwarna biru?");
        questionInput.setQuestionImageResources(
                new int[]{
                        R.drawable.ic_question_balls2,
                }
        );
        questionInput.setAnswer("24");
        questionInput.setType(Question.TYPE_INPUT);
        questionInput.setTime(3);
        return questionInput;
    }

    private Question createQuestion4() {
        Question questionMultipleSelection = new Question();
        questionMultipleSelection.setQuestion("4. Gambar untuk grafik dari fungsi y = x² – 4x + 3");
        questionMultipleSelection.setAnswerImageResources(new int[]{
                R.drawable.ic_answer_function_graphic1,
                R.drawable.ic_answer_function_graphic2,
                R.drawable.ic_answer_function_graphic3,
                R.drawable.ic_answer_function_graphic4,
                R.drawable.ic_answer_function_graphic5,
        });
        questionMultipleSelection.setAnswer(0);
        questionMultipleSelection.setType(Question.TYPE_MULTIPLE_SELECTION);
        questionMultipleSelection.setUseSound(true);
        return questionMultipleSelection;
    }

    private Question createQuestion3() {
        Question questionInput = new Question();
        questionInput.setQuestion("3. Diketahui rumus fungsi f adalah f(x) = 4x-2. Jika f(a) = 26, maka nilai a adalah");
        questionInput.setAnswer("7");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion2() {
        Question questionMultipleSelection = new Question();
        questionMultipleSelection.setQuestion("2. Manakah yang merupakan lanjutan dari pola gambar di bawah?");
        questionMultipleSelection.setQuestionImageResources(new int[]{
                R.drawable.ic_question_pattern
        });
        questionMultipleSelection.setAnswerImageResources(new int[]{
                R.drawable.ic_answer_pattern1,
                R.drawable.ic_answer_pattern2,
                R.drawable.ic_answer_pattern3,
                R.drawable.ic_answer_pattern4,
                R.drawable.ic_answer_pattern5,
                R.drawable.ic_answer_pattern6,
        });
        questionMultipleSelection.setAnswer(0);
        questionMultipleSelection.setType(Question.TYPE_MULTIPLE_SELECTION);
        return questionMultipleSelection;
    }

    private Question createQuestion1() {
        Question questionInput = new Question();
        questionInput.setQuestion("1. Rasid adalah seorang montir. Ia mampu memperbaiki sebuah mobil yang rusak dalam waku 3 jam. Berapa banyak mobil yang mampu ia perbaiki selama satu minggu?");
        questionInput.setAnswer("56");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    @Override
    public ArrayList<Question> getQuestionList() {
        return questionList;
    }
}
