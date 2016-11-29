package himka.gamehimka.question.teenager;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import himka.gamehimka.question.Question;
import himka.gamehimka.question.QuestionListProvider;

/**
 * @author hendrawd on 11/29/16
 */

public class TeenagerEasyQuestionListProvider implements QuestionListProvider, Parcelable {

    private ArrayList<Question> questionList = new ArrayList<>();

    public TeenagerEasyQuestionListProvider() {
        Question question1 = new Question();
        question1.setQuestion("Ini contoh question1");
        question1.setAnswer("Jawaban");
        question1.setType(Question.TYPE_INPUT);

        Question question2 = new Question();
        question2.setQuestion("Ini contoh question2");
        question2.setAnswer(1);
        question2.setType(Question.TYPE_MULTIPLE_SELECTION);
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

    protected TeenagerEasyQuestionListProvider(Parcel in) {
        this.questionList = new ArrayList<Question>();
        in.readList(this.questionList, Question.class.getClassLoader());
    }

    public static final Creator<TeenagerEasyQuestionListProvider> CREATOR = new Creator<TeenagerEasyQuestionListProvider>() {
        @Override
        public TeenagerEasyQuestionListProvider createFromParcel(Parcel source) {
            return new TeenagerEasyQuestionListProvider(source);
        }

        @Override
        public TeenagerEasyQuestionListProvider[] newArray(int size) {
            return new TeenagerEasyQuestionListProvider[size];
        }
    };
}
