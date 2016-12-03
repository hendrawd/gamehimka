package himka.gamehimka.question.moderate;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import himka.gamehimka.R;
import himka.gamehimka.question.Question;
import himka.gamehimka.question.QuestionListProvider;

/**
 * @author hendrawd on 11/29/16
 */

public class ModerateEasyQuestionListProvider implements QuestionListProvider, Parcelable {

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
        questionInput.setQuestion("5. Terdapat sepuluh titik pada suatu lingkaran diberi nomor 1 - 10. " +
                "Seekor katak melompat searah jarum jam satu satuan jika katak berada pada nomor prima dan tiga satuan jika bukan prima. " +
                "Jika mula - mula katak berada pada poisis nomor 1, dimanakah posisi katak setelah 2014 kali?");
        questionInput.setImageResources(new int[]{
                R.drawable.ic_question_10_numbers
        });
        questionInput.setAnswer("7");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion4() {
        Question questionInput = new Question();
        questionInput.setQuestion("4. Berapa banyak bangun segitiga yang terbentuk pada gambar di bawah ini?");
        questionInput.setImageResources(new int[]{
                R.drawable.ic_yellow_square_x
        });
        questionInput.setAnswer("4");
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.questionList);
    }

    protected ModerateEasyQuestionListProvider(Parcel in) {
        this.questionList = new ArrayList<Question>();
        in.readList(this.questionList, Question.class.getClassLoader());
    }

    public static final Parcelable.Creator<ModerateEasyQuestionListProvider> CREATOR = new Parcelable.Creator<ModerateEasyQuestionListProvider>() {
        @Override
        public ModerateEasyQuestionListProvider createFromParcel(Parcel source) {
            return new ModerateEasyQuestionListProvider(source);
        }

        @Override
        public ModerateEasyQuestionListProvider[] newArray(int size) {
            return new ModerateEasyQuestionListProvider[size];
        }
    };
}
