package himka.gamehimka.question.teenager;

import java.util.ArrayList;

import himka.gamehimka.R;
import himka.gamehimka.question.Question;
import himka.gamehimka.question.QuestionListProvider;

/**
 * @author hendrawd on 11/29/16
 */

public class TeenagerEasyQuestionListProvider implements QuestionListProvider {

    private ArrayList<Question> questionList = new ArrayList<>();

    public TeenagerEasyQuestionListProvider() {
        questionList.add(createQuestion1());
        questionList.add(createQuestion2());
        questionList.add(createQuestion3());
        questionList.add(createQuestion4());
        questionList.add(createQuestion5());

    }

    private Question createQuestion5() {
        Question questionInput = new Question();
        questionInput.setQuestion("5. Terdapat sepuluh titik pada suatu lingkaran diberi nomor 1 - 10. " +
                "Seekor katak melompat searah jarum jam satu satuan jika katak berada pada nomor prima dan tiga satuan jika bukan prima. " +
                "Jika mula - mula katak berada pada poisis nomor 1, dimanakah posisi katak setelah 2014 kali?");
        questionInput.setQuestionImageResources(new int[]{
                R.drawable.ic_question_10_numbers
        });
        questionInput.setAnswer("7");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion4() {
        Question questionInput = new Question();
        questionInput.setQuestion("4. Berapa banyak bangun segitiga yang terbentuk pada gambar di bawah ini?");
        questionInput.setQuestionImageResources(new int[]{
                R.drawable.ic_yellow_square_x
        });
        questionInput.setAnswer("4");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion3() {
        Question questionInput = new Question();
        questionInput.setQuestion("3. Jika jarak kota A ke kota B adalah 5cm dengan skala 1 : 1.000.000, maka jarak kedua kota tersebut sebenarnya adalah ... Km");
        questionInput.setQuestionImageResources(new int[]{
                R.drawable.ic_question_map
        });
        questionInput.setAnswer("500");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion2() {
        Question questionInput = new Question();
        questionInput.setQuestion("2. Cara membaca pecahan(eja dengan tulisan) 1/2 adalah");
        questionInput.setAnswer("Setengah");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion1() {
        Question questionInput = new Question();
        questionInput.setQuestion("1. Urutkanlah pecahan berikut hingga sesuai urutannya!");
        questionInput.setQuestionImageResources(new int[]{
                R.drawable.ic_question_fraction
        });
        questionInput.setAnswer("1/7,4/7,5/7");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    @Override
    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

}
