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

public class ModerateHardQuestionListProvider implements QuestionListProvider, Parcelable {

    private ArrayList<Question> questionList = new ArrayList<>();

    public ModerateHardQuestionListProvider() {
        questionList.add(createQuestion1());
        questionList.add(createQuestion2());
        questionList.add(createQuestion3());
        questionList.add(createQuestion4());
        questionList.add(createQuestion5());
    }

    private Question createQuestion5() {
        Question questionInput = new Question();
        questionInput.setQuestion("5. Jika yang mempunyai hobi menari sebanyak 20 siswa, maka yang mempunyai hobi membaca ada ... siswa");
        questionInput.setImageResources(new int[]{
                R.drawable.ic_question_diagram
        });
        questionInput.setAnswer("25");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion4() {
        Question questionInput = new Question();
        questionInput.setQuestion("4. Banyak titik pada pola terakhir adalah");
        questionInput.setImageResources(new int[]{
                R.drawable.ic_question_triangle_pattern
        });
        questionInput.setAnswer("21");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion3() {
        Question questionInput = new Question();
        questionInput.setQuestion("3. Segitiga mana sajakah yang kongruen? Contoh format jawaban: \n3 dengan 7, 1 dengan 2");
        questionInput.setImageResources(new int[]{
                R.drawable.ic_question_congruent_triangle
        });
        questionInput.setAnswer("3 dengan 7, 6 dengan 8");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion2() {
        Question questionDragAndDrop = new Question();
        questionDragAndDrop.setQuestion("2. Drag dan drop operasi himpunan di bawah agar sesuai");
        questionDragAndDrop.setImageResources(new int[]{
                R.drawable.ic_answer_intersection,//first half items will be the items that dragged
                R.drawable.ic_answer_union,
                R.drawable.ic_answer_union_no_match,

                R.drawable.ic_question_union,//second half items will be the item that listen the drag
                R.drawable.ic_question_union_no_match,
                R.drawable.ic_question_intersection,
        });
        questionDragAndDrop.setAnswer(new int[]{
                R.drawable.ic_answer_union,
                R.drawable.ic_answer_union_no_match,
                R.drawable.ic_answer_intersection
        });
        questionDragAndDrop.setType(Question.TYPE_DRAG_AND_DROP);
        return questionDragAndDrop;
    }

    private Question createQuestion1() {
        Question questionInput = new Question();
        questionInput.setQuestion("1. Urutkanlah bilangan berikut dari yang terkecil hingga terbesar!\n0,167;1/7;1/2;0,2;0,33;25%;");
        questionInput.setAnswer("1/7;0,167;0,2;25%;0,33;1/2");
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

    protected ModerateHardQuestionListProvider(Parcel in) {
        this.questionList = new ArrayList<Question>();
        in.readList(this.questionList, Question.class.getClassLoader());
    }

    public static final Creator<ModerateHardQuestionListProvider> CREATOR = new Creator<ModerateHardQuestionListProvider>() {
        @Override
        public ModerateHardQuestionListProvider createFromParcel(Parcel source) {
            return new ModerateHardQuestionListProvider(source);
        }

        @Override
        public ModerateHardQuestionListProvider[] newArray(int size) {
            return new ModerateHardQuestionListProvider[size];
        }
    };
}
