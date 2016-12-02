package himka.gamehimka.question.beginner;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import himka.gamehimka.question.Question;
import himka.gamehimka.question.QuestionListProvider;

/**
 * @author hendrawd on 11/29/16
 */

public class BeginnerEasyQuestionListProvider implements QuestionListProvider, Parcelable {

    private ArrayList<Question> questionList = new ArrayList<>();

    public BeginnerEasyQuestionListProvider() {
//        for (int i = 0; i < 3; i++) {
//            Question question1 = new Question();
//            question1.setQuestion("Ini contoh question1");
//            question1.setAnswer("Jawaban");
//            question1.setType(Question.TYPE_INPUT);
//            questionList.add(question1);
//        }

//        for (int i = 0; i < 3; i++) {
//            Question question2 = new Question();
//            question2.setQuestion("Ini contoh question2");
//            question2.setImageResources(new int[]{
//                    R.drawable.ic_kubus1,
//                    R.drawable.ic_kubus2,
//                    R.drawable.ic_kubus3,
//                    R.drawable.ic_kubus4,
//            });
//            question2.setAnswer(1);
//            question2.setType(Question.TYPE_MULTIPLE_SELECTION);
//            questionList.add(question2);
//        }

//        Question questionDragAndDrop = new Question();
//        questionDragAndDrop.setQuestion("Mbah marijan pergi ke sawah sama mas kipli");
//        questionDragAndDrop.setImageResources(new int[]{
//                R.drawable.ic_paint,//first half items will be the items that dragged
//                R.drawable.ic_ball,
//                R.drawable.ic_sandwich,
//
//                R.drawable.ic_circle,//second half items will be the item that listen the drag
//                R.drawable.ic_triangle,
//                R.drawable.ic_rectangle,
//        });
//        questionDragAndDrop.setAnswer(new int[]{
//                R.drawable.ic_ball,
//                R.drawable.ic_sandwich,
//                R.drawable.ic_paint
//        });
//        questionDragAndDrop.setType(Question.TYPE_DRAG_AND_DROP);
//        questionList.add(questionDragAndDrop);
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

    protected BeginnerEasyQuestionListProvider(Parcel in) {
        this.questionList = new ArrayList<Question>();
        in.readList(this.questionList, Question.class.getClassLoader());
    }

    public static final Parcelable.Creator<BeginnerEasyQuestionListProvider> CREATOR = new Parcelable.Creator<BeginnerEasyQuestionListProvider>() {
        @Override
        public BeginnerEasyQuestionListProvider createFromParcel(Parcel source) {
            return new BeginnerEasyQuestionListProvider(source);
        }

        @Override
        public BeginnerEasyQuestionListProvider[] newArray(int size) {
            return new BeginnerEasyQuestionListProvider[size];
        }
    };
}
