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
        Question questionMultipleSelection = new Question();
        questionMultipleSelection.setQuestion("5. Gambar yang manakah yang tidak sesuai dengan gambar-gambar lainnya?");
        questionMultipleSelection.setAnswerImageResources(new int[]{
                R.drawable.ic_purple_rectangular,
                R.drawable.ic_brown_trapesium,
                R.drawable.ic_yellow_rhombus,
                R.drawable.ic_blue_triangle,
        });
        questionMultipleSelection.setAnswer(3);
        questionMultipleSelection.setType(Question.TYPE_MULTIPLE_SELECTION);
        return questionMultipleSelection;
    }

    private Question createQuestion4() {
        Question questionDragAndDrop = new Question();
        questionDragAndDrop.setQuestion("4. Drag dan drop nama ke gambar fungsi sehingga sesuai");
        questionDragAndDrop.setQuestionImageResources(new int[]{
                R.drawable.ic_answer_cosinus,
                R.drawable.ic_answer_sinus,
                R.drawable.ic_answer_tangen,
                R.drawable.ic_question_tangen,
                R.drawable.ic_question_sinus,
                R.drawable.ic_question_cosinus,
        });
        questionDragAndDrop.setAnswer(new int[]{
                R.drawable.ic_answer_tangen,
                R.drawable.ic_answer_sinus,
                R.drawable.ic_answer_cosinus,
        });
        questionDragAndDrop.setType(Question.TYPE_DRAG_AND_DROP);
        questionDragAndDrop.setUseSound(true);
        return questionDragAndDrop;
    }

    private Question createQuestion3() {
        Question questionInput = new Question();
        questionInput.setQuestion("3. Ada percobaan pelemparan dua buah dadu.\nTentukan munculnya angka genap pada dadu pertama dan angka ganjil prima pada dadu kedua!");
        questionInput.setQuestionImageResources(
                new int[]{
                        R.drawable.ic_dadu
                }
        );
        questionInput.setAnswer("1/6");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion2() {
        Question questionInput = new Question();
        questionInput.setQuestion("2. Umur Jaka 3 tahun lebih tua dari pada umur Dito. Jika jumlah umur mereka 27 tahun, maka berapa tahunkah umur Jaka?");
        questionInput.setAnswer("15");
        questionInput.setType(Question.TYPE_INPUT);
        return questionInput;
    }

    private Question createQuestion1() {
        Question questionInput = new Question();
        questionInput.setQuestion("1. Jumlahkan semua kubus yang ada dalam gambar");
        questionInput.setQuestionImageResources(
                new int[]{
                        R.drawable.ic_kubus1,
                        R.drawable.ic_kubus2,
                        R.drawable.ic_kubus3,
                        R.drawable.ic_kubus4,
                        R.drawable.ic_kubus5,
                        R.drawable.ic_kubus6,
                }
        );
        questionInput.setAnswer("39");
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
