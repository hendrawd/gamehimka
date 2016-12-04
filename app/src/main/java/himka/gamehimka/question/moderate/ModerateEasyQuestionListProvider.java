package himka.gamehimka.question.moderate;

import java.util.ArrayList;

import himka.gamehimka.R;
import himka.gamehimka.question.Question;
import himka.gamehimka.question.QuestionListProvider;

/**
 * @author hendrawd on 11/29/16
 */

public class ModerateEasyQuestionListProvider implements QuestionListProvider {

    private ArrayList<Question> questionList = new ArrayList<>();

    public ModerateEasyQuestionListProvider() {
        questionList.add(createQuestion1());
        questionList.add(createQuestion2());
        questionList.add(createQuestion3());
        questionList.add(createQuestion4());
        questionList.add(createQuestion5());

    }

    private Question createQuestion5() {
        Question questionInput = new Question();
        questionInput.setQuestion("5. Hasil dari (123 x 123) : 3 adalah");
        questionInput.setAnswer("5043");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion4() {
        Question questionInput = new Question();
        questionInput.setQuestion("4. Isilah berapa banyak jeruk yang dapat menimbangi timbangan terakhir");
        questionInput.setQuestionImageResources(new int[]{
                R.drawable.ic_question_fruit1,
                R.drawable.ic_question_fruit2,
                R.drawable.ic_question_fruit3
        });
        questionInput.setAnswer("10");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion3() {
        Question questionInput = new Question();
        questionInput.setQuestion("3. Setiap Cing adalah Cang. Ada empat Cung yang juga Cang. Tidak ada Cung yang juga Cing. Jika banyaknya Cang adalah 19, dan lima diantaranya tidak Cing dan tidak Cung, maka banyaknya Cing adalah");
        questionInput.setAnswer("10");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion2() {
        Question questionInput = new Question();
        questionInput.setQuestion("2. 2 hari yang lalu adalah hari Selasa. Tentukan hari apakah 1000 hari lagi dari hari ini!");
        questionInput.setAnswer("Rabu");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion1() {
        Question questionInput = new Question();
        questionInput.setQuestion("1. Ada deret angka 18, 16, 14, 19, 17, 15, angka selanjutnya adalah");
        questionInput.setUseSound(true);
        questionInput.setAnswer("20");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    @Override
    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

}
